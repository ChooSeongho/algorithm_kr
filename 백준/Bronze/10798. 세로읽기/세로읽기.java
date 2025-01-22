import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = 5;
        int max_len = 0;
        char[][] res = new char[5][15];

        for(int i = 0; i < tc; i++) {
            String line_str = br.readLine();
            max_len = Math.max(line_str.length(), max_len);
            for(int j = 0; j < line_str.length(); j++) {
                res[i][j] = line_str.charAt(j);
            }
        }
        br.close();

        for(int i = 0; i < max_len; i++) {
            for(int j = 0; j < res.length; j++) {
                if(Character.getNumericValue(res[j][i]) == -1) {
                    continue;
                }
                bw.write(String.valueOf(res[j][i]));
            }
        }
        bw.flush();
        bw.close();
    }
}