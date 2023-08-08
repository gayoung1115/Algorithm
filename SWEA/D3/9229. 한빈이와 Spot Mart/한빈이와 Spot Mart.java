import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int m;
    static int []snack ;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        int result = -1;
        for(int test=1;test<=testCase;test++) {
            StringTokenizer st =  new StringTokenizer(br.readLine(), " ");
            
            n =  Integer.parseInt(st.nextToken());
            m =  Integer.parseInt(st.nextToken());
            
            Queue<Integer> snackWeights = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                snackWeights.add(Integer.parseInt(st.nextToken())); 
            }

            int maxWeightSum = -1;

            // 두 과자 봉지의 무게 합이 M 이하인 경우에 대해 최대값 계산
            while (!snackWeights.isEmpty()) {
                int firstSnack = snackWeights.poll(); // 첫 번째 과자 무게
                for (int weight : snackWeights) {
                    int totalWeight = firstSnack + weight;
                    if (totalWeight <= m && totalWeight > maxWeightSum) {
                        maxWeightSum = totalWeight;
                    }
                }
            }

            System.out.println("#" + test + " " + maxWeightSum);
            
        }
        
        
    }

}