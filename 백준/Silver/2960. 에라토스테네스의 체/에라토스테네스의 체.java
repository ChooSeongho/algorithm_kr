import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] checked = new boolean[N+1];

        int count = 0;
        for(int i = 2; i <= N; i++) {
            if (checked[i]) {
                continue;
            }

            for (int j = i; j <= N; j += i) {
                if (!checked[j]) {
                    checked[j] = true;
                    count++;
                }
                if (count == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}