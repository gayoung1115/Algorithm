import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int number[];
	static int maxN =Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st =  new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		number = new int[n];
		st =  new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		sumMax(0,k);
		System.out.println(maxN);
	}
	private static void sumMax(int start,int range) {
		if(start+range>n)return;
		int temp =0;
		for(int i=start;i<start+range;i++) {
			temp += number[i];
		}
		if(maxN<temp) maxN=temp;
		sumMax(start+1,range);
		
	}

}