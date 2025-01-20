import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] res = new int[N][M];
        for(int i = 0; i < N*2; i++) {
            int[] line_num = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
            for(int j = 0; j < line_num.length; j++) {
                res[i%N][j%M] += line_num[j];
            }
        }
        br.close();
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[i].length; j++) {
                bw.write(res[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}