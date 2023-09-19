import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static String[][] map;
	static boolean[][] isVisited;
	static int[] dx = {-1, 0, 1, 0}; //북, 동, 남, 서
	static int[] dy = {0, 1, 0, -1};
	
	static int roomSize; // 방 넓이
	static int brokenRoomSize; // 벽 부수고 나서 방 최대 넓이
	static HashMap<String, Integer> mergeRoom = new HashMap<>(); // 방 번호, 넓이

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 가로 길이
		M = Integer.parseInt(st.nextToken()); // 세로 길이
		
		map = new String[M+1][N+1];
		isVisited = new boolean[M+1][N+1];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = String.format("%04d", Integer.parseInt(Integer.toBinaryString(num)));// 2진수로 변환함 + 4자리수만 들어가게
			}
		}
		
		int roomCnt = 0; // 첫 번째 질문: 방의 개수
		int roomMax = 0; // 가장 넓은 방 크기
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				if(!isVisited[i][j]) {
					roomCnt++; // 첫 번째 질문: 방의 개수
					roomSize = 1; // 방 넓이
					bfs(i, j, roomCnt);
					
					mergeRoom.put(String.valueOf(roomCnt), roomSize); // A방 갯수가 A방의 이름이 됨, 넓이
					roomMax = Math.max(roomMax, roomSize);
				}
			}
		}
		
		//벽 부수고 부순 뒤 방 최대 넓이 구하기
		breakWall();
		
		System.out.println(roomCnt);
		System.out.println(roomMax);
		System.out.println(brokenRoomSize);
	}
	
	static void bfs(int x, int y, int cnt) {
		Queue<Pos> que = new LinkedList<>();
		
		que.add(new Pos(x, y));
		isVisited[x][y] = true;
		
		while(!que.isEmpty()) {
			Pos p = que.poll();

			int curX = p.x;
			int curY = p.y;
			
			String direction = map[curX][curY]; // 이진수 가져오기
			
			map[curX][curY] = String.valueOf(cnt); // 방번호 넣기 -> 벽 부쉇을 때 합친 크기 구하기 쉬우려고 미리 바꾸는 것
			
			for(int t=0; t<4; t++) {
				int nx = curX + dx[t];
				int ny = curY + dy[t];
				
				if(nx < 1 || ny < 1 || nx > M || ny > N) continue;
				
				// 동쪽으로 이동 가능
				if(direction.charAt(1) == '0' && t == 1 && !isVisited[nx][ny]) {
					que.add(new Pos(nx, ny));
					isVisited[nx][ny] = true;
					roomSize++;
				}
				// 남쪽으로 이동 가능
				if(direction.charAt(0) == '0' && t == 2 && !isVisited[nx][ny]) {
					que.add(new Pos(nx, ny));
					isVisited[nx][ny] = true;
					roomSize++;
				}
				// 북쪽으로 이동 가능
				if(direction.charAt(2) == '0' && t == 0 && !isVisited[nx][ny]) {
					que.add(new Pos(nx, ny));
					isVisited[nx][ny] = true;
					roomSize++;
				}
				// 서쪽으로 이동 가능
				if(direction.charAt(3) == '0' && t == 3 && !isVisited[nx][ny]) {
					que.add(new Pos(nx, ny));
					isVisited[nx][ny] = true;
					roomSize++;
				}
			}
		}
	}
	
	static void breakWall() {
		
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				String aRoom = map[i][j]; // A방 이름
				
				for(int t=0; t<4; t++) {
					int nx = i + dx[t];
					int ny = j + dy[t];
					
					if(nx < 1 || ny < 1 || nx > M || ny > N) continue;
					
					String bRoom = map[nx][ny]; // B방 이름
					
					if(aRoom.equals(bRoom)) continue; // A좌표와 B좌표가 원래 같은 방 안이면 continue
					
					if(!aRoom.equals(bRoom)) { // A좌표의 이름과 B좌표의 이름이 다르면 -> 서로 다른 방이다 -> 합쳐서 크기 구함
						brokenRoomSize = Math.max(brokenRoomSize, mergeRoom.get(aRoom) + mergeRoom.get(bRoom));
					}
					
				}
			}
		}
	}
	
	static class Pos{
		int x, y;
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}

	}
}