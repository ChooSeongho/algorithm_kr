import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        for(int i = 1; i < n; i++){
            int mod = gcd(arr[0], arr[i]);
            bw.write((arr[0] / mod) + "/" + (arr[i] / mod));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    public static int gcd(int a, int b){
        if(a%b == 0) return b;
        else return gcd(b,a%b);
    }
}
