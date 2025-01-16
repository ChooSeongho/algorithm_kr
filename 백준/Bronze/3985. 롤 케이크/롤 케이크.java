import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 롤케이크 길이
		int N = sc.nextInt(); // 방청객 수
		boolean[] used = new boolean[L+1];
//		int[] getL = new int[N+1]; // 실제 받은 롤케잌 수
//		int[] guess = new int[N+1];
		int[] guessMax = new int[2];
		int[] getMax = new int[2];
		
		for(int i = 1; i <= N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			if(guessMax[1] < end - start) {
				guessMax[0] = i;
				guessMax[1] = end - start;
			}
			int get = 0;
			for(int j = start; j<= end; j++) {
				if(!used[j]) {
					used[j] = true;
					get++;
				}
			}
			if(getMax[1] < get) {
				getMax[0] = i;
				getMax[1] = get;
			}
		}
		
		System.out.println(guessMax[0]);
		System.out.println(getMax[0]);

	}

}