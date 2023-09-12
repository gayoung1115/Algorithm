import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int happy[], life[];
	static int max =0;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new int[n];
		happy = new int[n];
		life = new int[n];
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			life[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		combi();
		System.out.println(max);
	}
	public static void combi() {
		for(int i=0; i < 1<<n; i++) {
			int sum =0;
			int li = 0;
	        for(int j=0; j<n; j++) {
	            if((i & 1<<j) != 0) {
	            	sum += happy[j];
	            	li += life[j];
	            }
	            
	        }
	        if(li<100 && sum>max) max =sum;
	    }
		

	}
}