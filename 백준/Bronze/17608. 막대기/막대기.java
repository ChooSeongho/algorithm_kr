import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int max_height = 0;
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            stack.push(sc.nextInt());
        }
        while(!stack.isEmpty()) {
            int height = stack.pop();
            if(height > max_height) {
                max_height = height;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
