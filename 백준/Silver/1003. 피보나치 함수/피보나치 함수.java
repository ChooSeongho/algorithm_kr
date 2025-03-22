import java.io.*;

public class Main {
    static int[][] arr = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T  = Integer.parseInt(br.readLine());
        arr[0][0] = arr[1][1] = 1;
        for(int i = 2; i <= 40; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] res = fibo(n);
            bw.write(res[0] + " " + res[1]);
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int[] fibo(int n) {
        if(arr[n][0] != 0 || arr[n][1] != 0) {
            return arr[n];
        } else {
            int[] a = fibo(n-1);
            int[] b = fibo(n-2);
            arr[n][0] = a[0] + b[0];
            arr[n][1] = a[1] + b[1];
            return arr[n];
        }
    }
}