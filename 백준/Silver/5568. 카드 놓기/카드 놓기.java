import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int N, K, card[],result[];
	static StringBuilder sb = new StringBuilder();
	static boolean isCheck[];
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		card = new int[N];
		isCheck = new boolean[N];
		result = new int[K];
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		isPick(0);
		System.out.println(set.size());
	}
	private static void check() {
		for(int i=0;i<K;i++) {
			sb.append(card[result[i]]);

		}
		set.add(Integer.parseInt(sb.toString()));
		sb.setLength(0);
	}
	
	private static void isPick(int k) {
		if(k==K) {
			check();
		}
		else {
			for(int i=0;i<N;i++) {
				if(!isCheck[i]) {
					result[k] = i;
					isCheck[i] = true;
					isPick(k+1);
					isCheck[i] = false;
				}

			}
		}
		
	}


}