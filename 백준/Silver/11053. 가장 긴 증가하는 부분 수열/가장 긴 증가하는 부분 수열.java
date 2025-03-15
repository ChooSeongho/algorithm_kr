import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // 수열 저장 배열
		ArrayList<Integer> lis = new ArrayList<>(); // 최장 부분 수열 저장 리스트
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) { // 수열 저장
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		lis.add(arr[0]); // 첫번째 수열을 최장 부분 수열 리스트의 처음으로 저장
		for(int i = 1; i < N; i++) { // 최장 부분 수열 구하기
			int curIdx = lis.size() - 1; // 최장 부분 수열의 마지막 인덱스
			if(lis.get(curIdx) < arr[i]) { // 현재까지의 최장 부분 수열의 마지막 값보다 큰 경우
				lis.add(arr[i]);
			} else { // 현재까지의 최장 부분 수열의 마지막 값보다 작은 경우
				while(lis.get(curIdx) >= arr[i]) {
					curIdx--;
					if(curIdx == -1) {
						break;
					}
				}
				lis.set(curIdx+1, arr[i]);
			}
//			for(int k : lis) {
//				System.out.print(k + " ");
//			}
//			System.out.println();
		}
		
		
		System.out.println(lis.size());
	}

}