import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int isVisited[];
	static int depth[];
	static int result[];
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<Integer>[] adjList = new LinkedList[n+1];
		isVisited = new int[n+1];
		result = new int[n];
		depth = new int[n+1];
		for(int i=1;i<=n;i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjList[start].add(end);
			depth[end]++;
		}
		
		//배열 오름차순 정렬
		for(int i=1;i<=n;i++) {
			Collections.sort(adjList[i]);
		}
		
		dfs(adjList,n,1);
		System.out.println(sb.toString());

	}
	static private void dfs(LinkedList<Integer>[] adjList,int n,int count) {
		Queue<Integer> q = new PriorityQueue<>();
		for(int i=1;i<=n;i++) {
			if(isVisited[i]==0 && depth[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int temp = q.poll();
			isVisited[temp] = 1;
			for(int i : adjList[temp]) {
				
				depth[i]--;
			}
			sb.append(temp+" ");
			
			for(int i : adjList[temp]) {
				if(depth[i]==0) q.add(i);
			}
		}
		
	}
}