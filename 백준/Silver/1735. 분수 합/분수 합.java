import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int denominator = b * d;
        int numerator = (a*d) + (b*c);
        int gcd = gcd(numerator,denominator);
        denominator /= gcd;
        numerator /= gcd;

        System.out.println(numerator + " " + denominator);
    }
    public static int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}