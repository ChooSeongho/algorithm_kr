import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 1;
        int[] res = fibonaci(N);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] fibonaci(int n) {
        int cnt = 0;
        for(int i=3; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            cnt++;
        }
        return new int[] {arr[n], cnt};
    }
}
