import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] paper = new boolean[101][101];
        int res = 0;
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = x; j < x+10; j++) {
                for(int k = y; k < y+10; k++) {
                    if(!paper[j][k]) {
                        paper[j][k] = true;
                        res++;
                    }
                }
            }
        }
        br.close();
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}