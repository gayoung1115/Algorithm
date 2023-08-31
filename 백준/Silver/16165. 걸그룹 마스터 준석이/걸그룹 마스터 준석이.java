import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> ha = new HashMap();
		Map<String, String[]> team = new HashMap();
		for(int i=0;i<n;i++) {
			String teamName = br.readLine();
			int count = Integer.parseInt(br.readLine());
			String []group = new String[count];
			for(int j=0;j<count;j++) {
				String name = br.readLine();
				group[j] = name;
				ha.put(name, teamName);
			}
			Arrays.sort(group);
			team.put(teamName,group);
		}
		
	
		for(int i=0;i<m;i++) {
			String pro = br.readLine();
			int state = Integer.parseInt(br.readLine());
			if(state==0) { //팀이름
				for(String name:team.get(pro)) {
					sb.append(name).append("\n");
				}
			}
			if(state==1) {
				sb.append(ha.get(pro)).append("\n");
			}
		}
		System.out.println(sb.toString());
		
		
	}
}