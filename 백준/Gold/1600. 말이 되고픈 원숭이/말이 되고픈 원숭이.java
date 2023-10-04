import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int k,n,m;
	static int[][]space;
	static boolean[][][]visited;
	static int jump_x[] = { 2,2, 1, -1, -2,-2, 1, -1 };
	static int jump_y[] = { 1, -1, 2, 2,  1, -1, -2, -2 };
	static int dx[] = { -1,1,0,0 };
	static int dy[] = { 0,0,-1,1 };
	static int result = Integer.MAX_VALUE ;
	static boolean success;
	
	static class Pos{
		int x,y;
		int count;
		int kCount;
		Pos(int x, int y,int count, int kCount){
			this.x = x;
			this.y = y;
			this.count = count; // 말 움직인 횟수
			this.kCount = kCount;// 점프 횟수
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		space = new int[n][m];
		visited = new boolean[n][m][k+1];
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		start(0,0,0);
		if(!success) {
			System.out.println("-1");
		}
		else {
			System.out.println(result);
		}
		

		
	}
	static private void start(int x, int y,int count) {
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(x,y,0,0));
		visited[x][y][0] = true;
		
		while(!que.isEmpty()) {
			Pos p  = que.poll();
			int cx = p.x;
			int cy = p.y;
			if(cx==(n-1) && cy==(m-1)) {
				success = true;
				result = p.count;
				return;
			}
			
			for(int t=0;t<4;t++) {
				int tx = cx + dx[t];
				int ty = cy + dy[t];
				
				if(tx>=0 && tx<n && ty>=0 && ty<m && !visited[tx][ty][p.kCount] && space[tx][ty]==0) {	
					visited[tx][ty][p.kCount] = true;
					que.add(new Pos(tx, ty, p.count+1, p.kCount));
					
				}
			}
			
			if(p.kCount<k) {
				for(int t=0;t<8;t++) {
					int tx = cx + jump_x[t];
					int ty = cy +jump_y[t];
					if(tx>=0 && tx<n && ty>=0 && ty<m && !visited[tx][ty][p.kCount+1] && space[tx][ty]==0) {	
						visited[tx][ty][p.kCount+1] = true;
						que.add(new Pos(tx, ty, p.count+1, p.kCount+1));
						
					}
				}
			}
		}
		
	}
}