import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Franklin", 100);
        map.put("Grant", 50);
        map.put("Jackson", 20);
        map.put("Hamilton", 10);
        map.put("Lincoln", 5);
        map.put("Washington", 1);

        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            while(st.hasMoreTokens()) {
                answer += map.get(st.nextToken());
            }
            bw.write("$" + answer + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
