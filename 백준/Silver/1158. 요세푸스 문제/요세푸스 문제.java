import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int num = k-1;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		System.out.print("<");
		for(int i = 0; i < N; i++) {
			if(i != N-1) {				
				System.out.print(list.get(num) + ", ");
			} else {
				System.out.print(list.get(num));
			}
			list.remove(num);
			num += k-1;
			if(num >= (N-1)-i) {
				try {					
					num = num % (N-i-1);
				} catch(Exception e) {
					
				}
			}
		}
		System.out.print(">");
		
	}
}
