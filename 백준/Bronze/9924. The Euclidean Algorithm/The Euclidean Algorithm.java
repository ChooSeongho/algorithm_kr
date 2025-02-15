import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int answer = 0;
        while(a != b) {
            if(a - b == 0) {
                break;
            }
            if(b > a) {
                int temp = b;
                b = a;
                a = temp;
            }
            answer++;
            a -= b;
            
        }

        System.out.println(answer);
    }
}