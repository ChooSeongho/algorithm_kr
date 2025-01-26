import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int res_min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        find(A, B, 1);

        bw.write(String.valueOf(res_min == Integer.MAX_VALUE? -1 : res_min));
        bw.flush();
        bw.close();
    }

    public static void find(long cur, int target, int cnt) {
        if(cur > target) {
            return;
        }
        if(cur == target) {
            res_min = Math.min(res_min, cnt);
        }
        find(cur * 2, target, cnt+1);
        find(Long.parseLong(cur + "1"), target, cnt+1);
    }
}