import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int sq_N = (int) Math.round(Math.sqrt(N)+1);
        boolean[] checked = new boolean[N+1];
        checked[0] = true;
        checked[1] = true;

        for(int i = 2; i <= sq_N; i++) {
            if(checked[i]) {
                continue;
            }

            for(int j = i * i; j <= N; j+=i) {
                checked[j] = true;
            }
        }
        for(int i = M; i <=N; i++) {
            if(!checked[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
