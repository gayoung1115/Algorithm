import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(in.readLine());
        int[] switchStatus = new int[switchCount];

        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 0; i < switchCount; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(in.readLine());

        int[][] studentStatus = new int[studentCount][2];

        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 2; j++) {
                studentStatus[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int human = 0; human < studentCount; human++) {
            int humanNumber = studentStatus[human][1] - 1; // 스위치 번호를 배열 인덱스로 변환
            if (studentStatus[human][0] == 1) { // 남학생
                for (int i = humanNumber; i < switchCount; i += studentStatus[human][1]) {
                    switchStatus[i] = 1 - switchStatus[i];
                }
            } else { // 여학생
                int left = humanNumber - 1;
                int right = humanNumber + 1;
                switchStatus[humanNumber] = 1 - switchStatus[humanNumber]; // 중앙 스위치 상태 변경

                while (left >= 0 && right < switchCount && switchStatus[left] == switchStatus[right]) {
                    switchStatus[left] = 1 - switchStatus[left];
                    switchStatus[right] = 1 - switchStatus[right];
                    left--;
                    right++;
                }
            }
        }

        for (int i = 0; i < switchCount; i++) {
            System.out.print(switchStatus[i] + " ");
            if ((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}