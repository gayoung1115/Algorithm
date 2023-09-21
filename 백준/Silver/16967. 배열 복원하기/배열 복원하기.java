import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int h,w,x,y;
	static int[][] spaceB;
	static int[][] spaceA2;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int c = h+x;
		int r = w+y;
		spaceB = new int[c][r];
		
		for(int i=0;i<c;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<r;j++) {
				spaceB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findA();
		System.out.println(sb.toString());
		
	}
	private static void findA() {
		int [][]A = new int[h][w];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				int x2 = i-x;
				int y2 = j-y;
				if (x2 >= 0 && y2 >= 0) {
                    A[i][j] = spaceB[i][j] - A[x2][y2];
                } else {
                    A[i][j] = spaceB[i][j];
                }
				
				sb.append(A[i][j]+" ");
			}
			sb.append("\n");
		}
		
		
		
	}

}