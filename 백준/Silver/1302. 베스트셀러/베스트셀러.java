import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		HashMap<String,Integer> has = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String book = br.readLine();
			if(has.containsKey(book)) {
				int value = has.get(book);
				has.put(book, ++value);
			}
			else {
				
				has.put(book, 1);
			}
		}
		int max =0;
		String max_name ="";
		for(String i : has.keySet()) {
			if(max<has.get(i)) {
				max = has.get(i);
				max_name = i;
			}
			else if(max==has.get(i)) {
				if(max_name.compareTo(i)>0) {
					max_name = i;
				}
			}
		}
		
		System.out.println(max_name);

	}



}