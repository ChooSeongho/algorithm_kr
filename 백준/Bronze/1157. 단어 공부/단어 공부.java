import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine().toUpperCase();
			char result = '?';
			int max = 0;
			int[] arr = new int[26];
			for(int i = 0; i < line.length(); i++) {
				int idx = line.charAt(i) - 'A';
				arr[idx] ++;
				if(max < arr[idx]) {
					max = arr[idx];
					result = (char) ('A' + idx);
				} else if(max == arr[idx]) {
					result = '?';
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}