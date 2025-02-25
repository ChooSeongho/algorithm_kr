import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total_len = sc.nextInt();
        int cut_h = sc.nextInt();
        int cut_v = sc.nextInt();
        int thick = 4;
        System.out.println(Math.max(total_len - cut_h, cut_h) * Math.max(total_len - cut_v, cut_v) * thick);
    }
}