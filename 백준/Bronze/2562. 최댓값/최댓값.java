import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int line = 9;

        int res_max = 0;
        int res_idx = 0;

        for(int i = 0; i < line; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input >= res_max) {
                res_max = input;
                res_idx = i+1;
            }
        }
        br.close();
        bw.write(res_max + "\n" + res_idx);
        bw.flush();
        bw.close();

    }
}