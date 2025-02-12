import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0; i < TC; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long answer = 0;
            for(int x = 0; x < n-1; x++){
                for(int y = x+1; y < n; y++){
                    answer += gcd(arr[x], arr[y]);
                }
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
    public static int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}