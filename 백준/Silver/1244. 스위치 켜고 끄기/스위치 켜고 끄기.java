import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int[] arr = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int studentCnt = sc.nextInt();
		
		while(--studentCnt >= 0) {
			int gender = sc.nextInt();
			int index = sc.nextInt();
			
			if(gender == 1) {
				for(int i = index; i <= N; i += index) {
					arr[i] = (arr[i] == 0)? 1 : 0;
				}
			} else {
				int prev = index-1;
				int next = index+1;
				while(true) {
					if(prev < 1 || next > N) {
						break;
					}
					if((arr[prev] ^ arr[next]) == 1) {
						break;
					} else {
						arr[prev] = (arr[prev] == 0)? 1 : 0;
						arr[next] = (arr[next] == 0)? 1 : 0;
						prev--;
						next++;
					}
				}
				arr[index] = (arr[index] == 0)? 1 : 0;
			}
			
		}
		
		for (int i = 1; i <= N; i++) {
	        System.out.print(arr[i] + " ");
	        if (i % 20 == 0) {
	            System.out.println();
	        }
	    }
		
	}

}