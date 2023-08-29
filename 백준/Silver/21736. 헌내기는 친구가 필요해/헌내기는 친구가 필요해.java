import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static char space[][];
	static int checked[][];
	static int meet = 0;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		space = new char[n][m];
		checked = new int[n][m];
		// O는 빈공간 X는 벽 I는 도연이 P는 사람
		for(int i=0;i<n;i++) {
			 String temp = br.readLine();
			 for(int j=0;j<m;j++) {
				 space[i][j] =temp.charAt(j);
			 }
		}
		for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
				if(space[i][j]=='I') {
					
					find(i,j);
					if(meet==0) System.out.println("TT");
					else System.out.println(meet);
					break;
				}
			 }
		}
		
		

	
	}
	private static void find(int x, int y) {

		checked[x][y] = 1; //방문처리

		for(int i=0;i<4;i++) {
			int tx = x +dx[i];
			int ty = y +dy[i];

			if(tx<0 ||tx>=n||ty<0 ||ty>=m) continue;
			if(checked[tx][ty]==1) continue;
			if(space[tx][ty] == 'X') continue;
			if(space[tx][ty] == 'P') meet++;
			
			find(tx,ty);
		}
	}

}