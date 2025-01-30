import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int R1 = Integer.parseInt(st.nextToken());
        int R2 = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf((R2 * 2) - R1));
        bw.flush();
        bw.close();

    }
}
