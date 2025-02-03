import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if(s.equals("pop")) {
                if(stack.isEmpty()) {
                    bw.write(String.valueOf(-1));
                } else {
                    bw.write(String.valueOf(stack.pop()));
                }
                bw.newLine();
            } else if(s.equals("size")) {
                bw.write(String.valueOf(stack.size()));
                bw.newLine();
            } else if(s.equals("empty")) {
                if(stack.isEmpty()) {
                    bw.write(String.valueOf(1));
                } else {
                    bw.write(String.valueOf(0));
                }
                bw.newLine();
            } else if(s.equals("top")) {
                if(stack.isEmpty()) {
                    bw.write(String.valueOf(-1));
                } else {
                    bw.write(String.valueOf(stack.peek()));
                }
                bw.newLine();
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}