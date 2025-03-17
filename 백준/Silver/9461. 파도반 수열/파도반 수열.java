import java.io.*;

public class Main {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        arr = new long[101];
        arr[0] = arr[1] = arr[2] = arr[3] = 1;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long res = solve(n);
            bw.write(res + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static long solve(int n) {
        if (arr[n] != 0) {
            return arr[n];
        } else {
            return arr[n] = solve(n - 2) + solve(n - 3);
        }
    }
}