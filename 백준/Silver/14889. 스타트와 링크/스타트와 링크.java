import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int choice[];
	static int space[][];
	static int Min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		space = new int[n][n];
		choice = new int[n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0;j<n;j++) {
				 space[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		comb(0,0);
		System.out.println(Min);
	}
	
	
	public static void comb(int count, int start) {
		if(count==n/2) {
			int s = 0;
			int l = 0;

			for(int i=0;i<n;i++) {
				if(choice[i]==1) {
					for(int j=0;j<n;j++) {
						if(j!=i && choice[j]==1)  s+= space[i][j];
					}
				}
				if(choice[i]==0) {
					for(int j=0;j<n;j++) {
						if(j!=i && choice[j]==0)  l+= space[i][j];
					}
				}
			}
			int val = Math.abs(s-l);
			Min = Math.min(val,Min);
			return;
		}
		for(int i=start;i<n;i++) {
			if(choice[i]!=1) {
				choice[i] =1;
				comb(count+1,i+1);
				choice[i] =0;
			}
			
		}
		

	}

}