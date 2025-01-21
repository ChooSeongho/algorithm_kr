import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 9, M = 9;
        int res_max = 0;
        int[] res_idx = {1, 1};

        for(int i = 0; i < N; i++) {
            int[] line_num = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            for(int j = 0; j < M; j++) {
                if(line_num[j] > res_max) {
                    res_max = line_num[j];
                    res_idx[0] = i+1;
                    res_idx[1] = j+1;
                }
            }
        }
        br.close();
        bw.write(res_max + "\n");
        bw.write(res_idx[0] + " " + res_idx[1]);
        bw.flush();
        bw.close();
    }
}