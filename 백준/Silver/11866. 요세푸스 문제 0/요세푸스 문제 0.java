import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        int[] arr = new int[N]; // 상태 저장할 배열(제거할 경우(cnt가 K에 도달한 경우) -1 저장)
        for(int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        int pos = 0; // 현재 위치
        int cnt = 0; // K까지 cnt
        int outputCnt = 0; // 전체 제거한 cnt
        System.out.print("<");
        while(outputCnt != arr.length) {
            if(arr[pos] != -1) {
                cnt++;
            }
            if(cnt == K) {
                if(outputCnt != arr.length - 1) {
                    System.out.print(arr[pos]+", ");
                } else {
                    System.out.print(arr[pos]);
                }
                arr[pos] = -1;
                cnt = 0;
                outputCnt++;
            }
            pos = (pos + 1) % arr.length;
        }
        System.out.print(">");
    }
}