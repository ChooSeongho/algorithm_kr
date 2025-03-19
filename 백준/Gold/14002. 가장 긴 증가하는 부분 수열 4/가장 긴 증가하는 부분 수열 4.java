import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
    
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    answer = Math.max(answer, dp[i]);
                }
            }
        }
        br.close();
    
        bw.write(answer + "\n");
    
        Stack<Integer> stack = new Stack<>();
        for (int i = N; i >= 1; i--) {
            if(answer == dp[i]) {
                stack.add(arr[i]);
                answer--;
            }
        }
    
        while(!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
    
        bw.flush();
        bw.close();
    }
}
