import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memo = new int[N+1];
		for(int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			min = Math.min(memo[i-1], Math.min(i % 3 == 0 ? memo[i/3] : Integer.MAX_VALUE, i % 2 == 0 ? memo[i/2] : Integer.MAX_VALUE));
			memo[i] = min + 1;
		}
		
		System.out.println(memo[N]);
	}

}