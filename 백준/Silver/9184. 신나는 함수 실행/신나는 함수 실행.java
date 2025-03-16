import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[21][21][21];
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) {
                break;
            }
            int res = W(a, b, c);
            bw.write(String.format("w(%d, %d, %d) = ", a, b, c) + res);
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int W(int a, int b, int c) {
        if((a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20) && arr[a][b][c] != 0) {
            return arr[a][b][c];
        }

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if(a > 20 || b > 20 || c > 20) {
            return arr[20][20][20] = W(20, 20, 20);
        } else if(a < b && b < c) {
            return arr[a][b][c] = W(a, b, c-1) + W(a, b-1, c-1) - W(a, b-1, c);
        }
        return arr[a][b][c] = W(a-1, b, c) + W(a-1, b-1, c) + W(a-1, b, c-1) - W(a-1, b-1, c-1);
    }
}