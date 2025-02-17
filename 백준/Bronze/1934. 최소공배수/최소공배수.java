import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lcm = (a * b) / gcd(a, b);
            bw.write(lcm + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int gcd(int a, int b) {
        if(a%b == 0) return b;
        return gcd(b, a%b);
    }
}
