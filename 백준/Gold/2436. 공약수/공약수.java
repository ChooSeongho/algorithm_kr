import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();

        long mul = (long)a * b;

        long min_a = Integer.MAX_VALUE;
        long min_b = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(mul); i++) {
            if(mul % i == 0) {
                if(min_a + min_b > i + (mul / i) && (int)getGCD((mul/i), i) == a){
                    min_a = i;
                    min_b = mul / i;
                }
            }
        }
        bw.write(min_a + " " + min_b);
        bw.flush();
        bw.close();
    }

    public static long getGCD(long a, long b) {
        if(a % b == 0) return b;
        return getGCD(b, a % b);
    }
}