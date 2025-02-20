import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int helmet_max = 0;
        int vest_max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            helmet_max = Math.max(helmet_max, Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            vest_max = Math.max(vest_max, Integer.parseInt(st.nextToken()));
        }
        br.close();
        bw.write(String.valueOf(helmet_max + vest_max));
        bw.flush();
        bw.close();
    }
}
