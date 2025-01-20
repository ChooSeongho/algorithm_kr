import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] res = new int[N];

        for(int i = 0; i < N; i++) {
            res[i] = i+1;
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer t_st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(t_st.nextToken()) - 1;
            int end = Integer.parseInt(t_st.nextToken()) - 1;

            for(; start <= end; start++, end--) {
                int temp = res[start];
                res[start] = res[end];
                res[end] = temp;
            }

        }
        br.close();
        for(int i = 0; i < res.length; i++) {
            bw.write(res[i] + " ");
        }
        bw.flush();
        bw.close();
    }

}