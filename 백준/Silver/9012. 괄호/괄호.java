import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(Character c : s.toCharArray()) {
                if(c.equals('(') || c.equals('{') || c.equals('[')) {
                    stack.push(c);
                } else {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    char compare_c = stack.pop();
                    if(c - compare_c > 2 || c - compare_c < 1) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                if(stack.isEmpty()) {
                    bw.write("YES");
                } else {
                    bw.write("NO");
                }
            } else {
                bw.write("NO");
            }
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}