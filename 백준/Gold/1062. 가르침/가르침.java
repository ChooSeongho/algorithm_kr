import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] words;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new int[N];
		answer = 0;
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < tmp.length(); j++) {
				int idx = tmp.charAt(j) - 'a';
				words[i] |= (1 << idx);
			}
		}
		if(K < 5) {
			System.out.println(0);
			return;
		}
		if(K == 26) {
			System.out.println(N);
			return;
		}
		int bit = 0;
		bit |= (1 << 'a' - 'a');
		bit |= (1 << 'c' - 'a');
		bit |= (1 << 'i' - 'a');
		bit |= (1 << 'n' - 'a');
		bit |= (1 << 't' - 'a');
		K -= 5;
		comb(0, 0, bit);
		
		System.out.println(answer);			
		
	}
	
	private static void comb(int idx, int target, int bit) {
		if(target == 'a' - 'a' || target == 'c' - 'a' || target == 'i' - 'a' || target == 'n' - 'a' || target == 't' - 'a') {
			target++;
		}
		
		if(idx == K) {
			int cnt = 0;
//			System.out.println("=============================");
			for(int i = 0; i < words.length; i++) {
				if((words[i] & bit) == words[i]) {
//					System.out.println("words = " + Integer.toBinaryString(words[i]));
//					System.out.println("cnt++ = " + Integer.toBinaryString(bit));
					cnt++;
				}
			}
			answer = Math.max(answer, cnt);
			return;
		}
		
		if(target == 26) {
			return;
		}
		
		comb(idx+1, target+1, bit | (1 << target));
		comb(idx, target+1, bit);
		
	}

}