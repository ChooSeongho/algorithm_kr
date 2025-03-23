import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp_l = new int[N];
        int[] dp_r = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            dp_l[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp_l[j] + 1 > dp_l[i]) {
                    dp_l[i] = dp_l[j] + 1;
                }
            }
        }

        for(int i = N - 1; i >= 0; i--) {
            dp_r[i] = 1;
            for(int j = N - 1; j > i; j--) {
                if(arr[j] < arr[i] && dp_r[j] + 1 > dp_r[i]) {
                    dp_r[i] = dp_r[j] + 1;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, dp_l[i] + dp_r[i] - 1);
        }
        System.out.println(answer);
    }
}