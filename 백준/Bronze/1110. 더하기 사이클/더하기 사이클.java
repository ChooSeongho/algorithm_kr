import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());
		int count = 0;
		int temp_target = target;
		
		while(true) {
			temp_target = (temp_target%10*10)+((temp_target/10+temp_target%10)%10);
			count++;
			if(temp_target == target) {
				break;
			}
		}
		
		System.out.println(count);
	}
	
}