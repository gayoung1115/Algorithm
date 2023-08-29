import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int space[][];
	static int checked[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,0-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max =0;
		n = Integer.parseInt(br.readLine());
		space = new int[n][n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0;j<n;j++) {
				 space[i][j] = Integer.parseInt(st.nextToken());
				 if(max<space[i][j]) max = space[i][j];
			 }
		}
		int result = 1;

		for(int h =0;h<=max;h++) {
			int count =0;
			checked = new int[n][n];
			for(int i=0;i<n;i++) {
				 for(int j=0;j<n;j++) {
					if(find(i,j,h)) {
						count++;
					}
				 }
			}

			if(count>result) result = count;
		}
		System.out.println(result);
		

	
	}
	private static boolean find(int x, int y,int height) {

		if(space[x][y]<height || checked[x][y]!=0) return false;
		checked[x][y] = 1; //방문처리

		for(int i=0;i<4;i++) {
			int tx = x +dx[i];
			int ty = y +dy[i];
			if(tx<0 ||tx>=n||ty<0 ||ty>=n) continue;
			if(checked[tx][ty]==1) continue;
			if(space[tx][ty]<height) continue;

			find(tx,ty,height);
		}
		return true;
		
	}

}