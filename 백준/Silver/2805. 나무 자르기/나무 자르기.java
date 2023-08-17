import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M, H, namu[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		namu = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			namu[i] =Integer.parseInt(st.nextToken());
		}
		
		System.out.println(UpperBound());

	}
	
	private static int UpperBound() {
		Arrays.sort(namu);
		int l = 0;
		int r = namu[M-1];
		int mid = 0;
		while (l < r) {
			mid = (l + r) / 2;
			if (Cut(mid) >= H) { // 자른값이 >H -> mid는 증가해야함;
				l = mid+1;
			} else {
				r = mid;
			}

		}
		
		return r-1;
	}
	
	private static long Cut(int cutMeter) {
		long cut =0;
		for(int i=0;i<M;i++) {
			if(cutMeter>=namu[i]) continue;
			else {
				cut += namu[i] -cutMeter;
			}
		}
		return cut;
		
	}

}