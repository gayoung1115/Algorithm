import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] height; // 높이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        height = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        int result =0;
        for(int i = 1; i < m - 1; i++) {
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            for(int j = i + 1; j < m; j++) {
                right = Math.max(height[j], right);
            }

            if(height[i] < left && height[i] < right) result += Math.min(left, right) - height[i];
        }
        System.out.println(result);

    }
}