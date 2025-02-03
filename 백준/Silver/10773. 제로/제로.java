import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= K; i++) {
            int n = sc.nextInt();
            if(n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }
        long n_sum = 0;
        while(!stack.isEmpty()) {
            n_sum += stack.pop();
        }
        System.out.println(n_sum);
    }
}
