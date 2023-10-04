import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[]space;
	static int[][]visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine()); //계단의 갯수
		space = new int[k+1];
		visited = new int[k+1][3];
		for(int i=1;i<=k;i++) {
			space[i] = Integer.parseInt(br.readLine());
		}
		
		visited[1][1] = space[1]; //초기값
		
		
		for(int i=2;i<=k;i++) {
			visited[i][1] = Math.max(visited[i-2][1]+space[i], visited[i-2][2]+space[i]);
			visited[i][2] = visited[i-1][1]+space[i];
		}
		
		int result = Math.max(visited[k][1], visited[k][2]);
		System.out.println(result);

	}

}