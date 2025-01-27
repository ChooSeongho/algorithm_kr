import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static int[][] mapping;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res_cnt = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        mapping = new int[N+1][N+1];

        for(int i = 0; i < M; i++) {
            StringTokenizer temp_st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(temp_st.nextToken());
            int m = Integer.parseInt(temp_st.nextToken());
            mapping[n][m] = 1;
            mapping[m][n] = 1;
        }
        br.close();

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                res_cnt++;
            }
        }
        bw.write(String.valueOf(res_cnt));
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx) {
        if(!visited[idx]) {
            visited[idx] = true;
            for(int i = 1; i <= N; i++) {
                if(mapping[idx][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}