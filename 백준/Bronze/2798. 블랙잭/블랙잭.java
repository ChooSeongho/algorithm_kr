import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int answer;
	static int[] combArr;
	static int r = 3; // 고르는 카드 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		combArr = new int[r];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		answer = 0;
		
//		for(int i = 0; i < (1 << arr.length); i++) {
//			int sum = 0;
//			int cnt = 0;
//			for(int j = 0; j < arr.length; j++) {
//				if((i & (1 << j)) != 0) {
//					sum += arr[j];
//					cnt++;
//					if(sum > M) {
//						sum = 0;
//						break;
//					}
//					if(cnt > 3) {
//						sum = 0;
//						break;
//					}
//				}
//			}
//			answer = Math.max(answer, sum);
//		}
		
		comb(0, 0);
		
		System.out.println(answer);

	}
	
	static void comb(int index, int target) {
		if(index == r) {
			int sum = 0;
			for(int i = 0; i < r; i++) {
				sum += combArr[i];
			}
			if(sum > M) {
				return;
			} else {
				answer = Math.max(answer, sum);
			}
			return;
		}
		
		if(target == N) return;
		
		combArr[index] = arr[target];
		comb(index+1, target+1);
		comb(index, target+1);
		
	}

}
