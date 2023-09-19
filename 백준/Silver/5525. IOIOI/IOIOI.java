import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static String st;
    static boolean visited[];
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        st = br.readLine();
        visited = new boolean[m];
        for(int i=0;i<m;i++){

            if(visited[i]==false && st.charAt(i)=='I') {
                visited[i] = true ;
                find(i);
            }
            else{
                visited[i] = true;
            }
        }
        System.out.println(result);

    }
    static private void find(int start){
        int i =1;
        int p =0;
        int last =0;
        while((start+i)<m){
            if(i%2==0){ //짝수 "I"
                if(st.charAt((start+i))== 'I'){
                    visited[(start+i)] = true ;
                    i++;
                    p++;
                }
                else{
                    visited[(start+i)-1] = false;
                    break;
                }
            }
            else{//홀수 "O"
                if(st.charAt((start+i))== 'O'){
                    visited[(start+i)] = true ;
                    i++;
                }
                else{
                    break;
                }
            }
        }
        if(p - (n-1)>0){
            result += p - (n-1);
        }

    }
}