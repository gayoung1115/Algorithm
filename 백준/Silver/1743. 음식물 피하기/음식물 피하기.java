import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] space;
	static boolean[][] visited;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int count ;
	
	static Queue<Node> qu = new LinkedList<>();
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x =x;
			this.y =y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		space = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			space[x][y] =1;
		}
		int max = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
//				count =0;
				count =1;
				if(visited[i][j] ==  false && space[i][j] == 1) {
					bfs(i,j);
//					dfs(i,j);
					max = Math.max(max, count);
				}
			}
		}
		System.out.println(max);
	}
	
	private static void dfs(int x,int y) {

		visited[x][y] = true;
		count++;


		for(int i=0;i<4;i++) {
			int tx = x +dx[i];
			int ty = y+ dy[i];
			if(0>tx || 0>ty || tx>=n || ty>=m) continue;
			if(visited[tx][ty]) continue;
			if(space[tx][ty] == 0) continue;
			dfs(tx,ty);
	
		}
	}
	
	private static void bfs(int x,int y) {
		qu.offer(new Node(x,y));
		visited[x][y] = true;
		while(!qu.isEmpty()) {
			Node temp = qu.poll();
			for(int i=0;i<4;i++) {
				int tx = temp.x +dx[i];
				int ty = temp.y+ dy[i];
				if(0>tx || 0>ty || tx>=n || ty>=m) continue;
				if(visited[tx][ty]) continue;
				if(space[tx][ty] == 0) continue;
				qu.add(new Node(tx,ty));
				visited[tx][ty] = true;
				count++;
			}
		}
	}

}