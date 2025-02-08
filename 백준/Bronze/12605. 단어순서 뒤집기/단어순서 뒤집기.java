import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            Stack<String> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }
            bw.write("Case #" + i + ": ");
            while(!stack.isEmpty()) {
                bw.write(stack.pop() + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}