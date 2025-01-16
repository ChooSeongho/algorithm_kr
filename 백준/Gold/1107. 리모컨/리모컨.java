import java.util.*;

public class Main {
	static String N;
	static boolean[] canUseNum; // false - 사용 가능, true - 사용 불가
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.next();
		canUseNum = new boolean[10];
		answer = Math.abs(Integer.parseInt(N) - 100);
		int canNotCnt = sc.nextInt();
		
		for(int i = 0; i < canNotCnt; i++) {
			int tmpNum = sc.nextInt();
			canUseNum[tmpNum] = true;
		}
		
		get(1,0,answer);
		
		System.out.println(answer);
		
	}
	
	static void get(int cnt, int tmpNum, int tmpSum) {
		answer = Math.min(answer, tmpSum);
		if(cnt == N.length()+2) {
			return;
		}
		for(int i = 0; i < 10; i++) {
			StringBuilder sb = new StringBuilder();
			if(!canUseNum[i]) {
				sb.append(tmpNum);
				sb.append(i);
				get(cnt+1, Integer.parseInt(sb.toString()), cnt + ((int)Math.abs(Integer.parseInt(N) - Integer.parseInt(sb.toString()))));
			}
		}
		
	}
}