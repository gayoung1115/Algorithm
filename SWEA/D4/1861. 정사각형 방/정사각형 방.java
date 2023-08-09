import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] rooms;
    static int[][] dp;  // 각 방에서 출발하여 이동 가능한 최대 방의 개수를 저장하는 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            rooms = new int[N + 1][N + 1];
            dp = new int[N + 1][N + 1];

            // 방의 숫자 입력 받기
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxRoomCount = 0;  // 최대로 이동할 수 있는 방의 개수
            int startRoom = 0;     // 출발해야 하는 방 번호

            // 각 방에서 출발하여 최대 이동 가능한 방의 개수 계산
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int roomCount = dfs(i, j);
                    if (roomCount > maxRoomCount) {
                        maxRoomCount = roomCount;
                        startRoom = rooms[i][j];
                    } else if (roomCount == maxRoomCount && rooms[i][j] < startRoom) {
                        startRoom = rooms[i][j];
                    }
                }
            }

            System.out.println("#" + tc + " " + startRoom + " " + maxRoomCount);
        }
    }

    // DFS를 사용하여 현재 위치에서 이동 가능한 최대 방의 개수 계산
    static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;  // 현재 방에서 이동 시작
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어나거나 숫자가 조건에 맞지 않으면 스킵
            if (nx < 1 || nx > N || ny < 1 || ny > N || rooms[nx][ny] != rooms[x][y] + 1) {
                continue;
            }

            dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
        }

        return dp[x][y];
    }
}