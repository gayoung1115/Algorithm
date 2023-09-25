import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test=0;test<T;test++) {
			int n = Integer.parseInt(br.readLine());
			//최대힙
			int temp[] = new int[n + 1];
            int sum[] = new int[n + 1];
            int dp[][] = new int[n + 1][n + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1;i<n+1;i++) {
				temp[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + temp[i];
			}
			for (int i = 1; i <= n; i++) {
                for (int from = 1; from + i <= n; from++) {
                    int to = from + i;
                    //min값을 구하기 때문에, 디폴트 값인 0이 들어있으면 비교식이 잘 작동하지 않습니다.
                    dp[from][to] = Integer.MAX_VALUE;
                    //d는 파일 합치기를 할 때, 시작 점에 따라서 값이 다르게 나오므로
                    //파일 합치기를 시작하는 지점을 다 다르게 해서, 최소 값을 찾습니다.
                    for (int d = from; d < to; d++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][d] + dp[d+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }
            System.out.println(dp[1][n]);
			
		}
	}
	
}