import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int even_sum = 0;
            int even_min = Integer.MAX_VALUE;
            while(st.hasMoreTokens()) {
                int input = Integer.parseInt(st.nextToken());
                if(input % 2 == 0) {
                    even_sum += input;
                    even_min = Math.min(even_min, input);
                }
            }
            bw.write(String.valueOf(even_sum + " " + even_min));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}