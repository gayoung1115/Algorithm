import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int max=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] li = new LinkedList[n];
		
		for(int i=0;i<n;i++) {
			li[i] = new LinkedList<>();
		}

		//값 입력받기
		for(int i=0;i<n;i++) {
			String temp = br.readLine();
			for(int j=0;j<n;j++) {
				if(temp.charAt(j)=='N') continue;
				else li[i].add(j);
			}
			
		}
		for(int i=0;i<n;i++) {
			find(li, i);
		}
		
		System.out.println(max);
		
	}
	
	

	private static void find(LinkedList<Integer>[] li,int start) {
		int isVisited[]= new int[n];
		for(int i : li[start]) {
			isVisited[i] =1;
			for(int k : li[i]) {
				if(isVisited[k]!=1) {
					isVisited[k] =1;
				}
			}
		}
		int count =0;	
		isVisited[start] =0;
		for(int i=0;i<n;i++) {
			if(isVisited[i]==1)count++;
		}
//		System.out.println(start+" "+Arrays.toString(isVisited));
		if(max<=count) {
			max = count;
		}
		
	}

}