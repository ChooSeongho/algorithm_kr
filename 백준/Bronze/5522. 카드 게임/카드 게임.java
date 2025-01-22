import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = 5;
        int res = 0;
        for(int i = 0; i < tc; i++) {
            res += Integer.parseInt(br.readLine());
        }
        br.close();
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}