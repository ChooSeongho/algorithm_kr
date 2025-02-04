import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
//                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    bw.write((stack.isEmpty() ? -1 : stack.pop()) + "\n");
                    break;
                case 3:
//                    System.out.println(stack.size());
                    bw.write(stack.size() + "\n");
                    break;
                case 4:
//                    System.out.println(stack.isEmpty() ? 1 : 0);
                    bw.write((stack.isEmpty() ? 1  : 0) + "\n");
                    break;
                case 5:
//                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    bw.write((stack.isEmpty() ? -1 : stack.peek()) + "\n");
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}