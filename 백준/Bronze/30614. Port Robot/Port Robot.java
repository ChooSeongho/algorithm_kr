import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String log = br.readLine();
        br.close();
        if(check(N, log)) {
            bw.write(String.valueOf(1));
        } else {
            bw.write(String.valueOf(0));
        }
        bw.flush();
        bw.close();
    }

    public static boolean check(int N, String log) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            char c = log.charAt(i);
            if(Character.isLowerCase(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty() || Character.toLowerCase(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}