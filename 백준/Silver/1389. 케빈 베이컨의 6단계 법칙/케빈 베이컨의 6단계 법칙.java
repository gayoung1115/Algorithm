import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int result [][];
	static int max = Integer.MAX_VALUE;
	static int maxN =0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new int[n+1][n+1];
		LinkedList<Integer>[] li = new LinkedList[n+1];
		
		for(int i=0;i<n+1;i++) {
			li[i] = new LinkedList<>();
		}

		//값 입력받기
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());

			int from =Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			li[from].add(to);
			li[to].add(from);
			
		}
		for(int i=1;i<n+1;i++) {
			bfs(li,i);
		}
		
		
		System.out.println(maxN);
	}
	
	

	private static void bfs(LinkedList<Integer>[] li,int start) {
		int isVisited[]= new int[n+1]; 
		
		Queue<Integer> qu = new LinkedList<>();
		qu.offer(start);

		while(!qu.isEmpty()) {
			int node = qu.poll();
			isVisited[node] =1;
			for(int i : li[node]) {
				if(isVisited[i]!=1) {
					result[start][i] = result[start][node]+1;
					isVisited[i]=1;
					qu.offer(i);
				}
			}
		}
		
		int sum =0;
		for(int i:result[start]) {
			sum+=i;
		}

		if(max>sum) {
			max = sum;
			maxN = start;
		}
		
	}

}