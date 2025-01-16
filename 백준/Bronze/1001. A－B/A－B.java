import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] tmp;
        int result;
        Scanner scanner = new Scanner(System.in);
        tmp = scanner.nextLine().split("\\s");
        result = Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[1]);
        System.out.println(result);
    }
}