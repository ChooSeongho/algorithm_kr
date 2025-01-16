import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			boolean is = false;
			int score = 1;
			String input = br.readLine();
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == 'O') {
					if(is) {
						score++;
					}
					is = true;
					arr[i] += score;
				} else {
					is = false;
					score = 1;
				}
			}
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
		
	}

}