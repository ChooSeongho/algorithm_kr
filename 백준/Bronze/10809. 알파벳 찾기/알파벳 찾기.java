import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] idxArr = new int[26];
		Arrays.fill(idxArr, -1);
		
		for(int i = 0; i < input.length(); i++) {
			int idx = input.charAt(i) - 'a';
			if(idxArr[idx] == -1) {	
				idxArr[idx] = i;
			}
		}
		
		for(int i = 0; i < idxArr.length; i++) {			
			System.out.print(idxArr[i] + " ");
		}
	}

}