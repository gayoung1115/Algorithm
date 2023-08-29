import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int space[][];
	static int max[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		space = new int[n][n];
		
		PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
		int max =0;
		int startX = 0;
		int startY = 0;
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0;j<n;j++) {
				 space[i][j] = Integer.parseInt(st.nextToken());
				 qu.add(space[i][j]);
			 }
		}
		int result =0;
		for(int i=0;i<n;i++) {
			result = qu.poll();
		}
		
		System.out.println(result);
	}


}