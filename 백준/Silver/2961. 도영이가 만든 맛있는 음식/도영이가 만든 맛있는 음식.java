import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Ing{
		int x;
		int y;
		public Ing(int x,int y) {
			this.x =x;
			this.y =y;
		}
	}
	static List<Ing> li;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 도영이가 만든 맛있는 음식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		li = new ArrayList<>();
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			li.add(new Ing(x,y));
		}
		int be = 1<<n;
		int min = 1000000000;
		for(int j=1;j<be;j++) {
			int xSum =1;
			int ySum =0;
			for(int k=0;k<n;k++) {
				if((j & (1<<k))!=0 ) {
					xSum *= li.get(k).x;
					ySum += li.get(k).y;
				}
			}
			if(min>Math.abs(xSum-ySum)) min = Math.abs(xSum-ySum);
		}
		System.out.println(min);
	}
}