import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            StringBuilder sb = new StringBuilder();
            String str = sc.next();
            sb.append(str.charAt(0)).append(str.charAt(str.length()-1));
            System.out.println(sb.toString());
        }
    }
}