import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int square = 1;
        int res = 0;

        for(int i = N.length()-1; i >=0; i--) {
            char c = N.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                res += (c - 'A' + 10) * square;
            } else {
                res += (c - '0') * square;
            }
            square *= B;
        }

        System.out.println(res);

    }
}