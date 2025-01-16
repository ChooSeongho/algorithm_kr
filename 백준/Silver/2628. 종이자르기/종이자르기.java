import java.util.Scanner;

public class Main {
	static int R;
	static int C;
	static int answer;
	static int[] cutArr;
	static int[] cutDirArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt(); // 열 개수
		R = sc.nextInt(); // 행 개수
		int cutCnt = sc.nextInt(); // 자르는 개수
		answer = 0;
		cutArr = new int[cutCnt]; // 자르는 위치 저장 배열
		cutDirArr = new int[cutCnt]; // 자르는 방향 저장 배열
		
		for(int i = 0; i < cutCnt; i++) {
			cutDirArr[i] = sc.nextInt(); // 가로 세로
			cutArr[i] = sc.nextInt(); // 자르는 위치
		}
		
		solve(0, 0, R, 0, C);
		
		System.out.println(answer);
		
	}
	
	static void solve(int cnt, int startR, int endR,  int startC, int endC) {
		if(cnt == cutArr.length) {
			answer = Math.max(answer, ((endR-startR) * (endC-startC)));
			return;
		}
		
		if(cutDirArr[cnt] == 0) {
			if(cutArr[cnt] < startR || cutArr[cnt] > endR) {
				solve(cnt+1, startR, endR, startC, endC);
			} else {
				solve(cnt+1, startR, cutArr[cnt], startC, endC);
				solve(cnt+1, cutArr[cnt], endR, startC, endC);
			}
		} else if(cutDirArr[cnt] == 1) {
			if(cutArr[cnt] < startC || cutArr[cnt] > endC) {
				solve(cnt+1, startR, endR, startC, endC);			
			} else {
				solve(cnt+1, startR, endR, startC, cutArr[cnt]);
				solve(cnt+1, startR, endR, cutArr[cnt], endC);	
			}
		}
		
		
	}

}