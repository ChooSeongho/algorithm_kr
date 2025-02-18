import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcd(a, b);
        int lcm = (a * b) / gcd;
        System.out.print(gcd + "\n" + lcm);
    }
    public static int gcd(int a, int b) {
        if(a % b == 0) return b;
        else return gcd(b, a % b);
    }
}