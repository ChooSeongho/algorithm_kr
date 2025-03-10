import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();
        sc.close();
        for(int i = 0; i < n; i++) {
            q.add(i+1);
        }
        int idx = 0;
        while(!q.isEmpty()) {
            if(idx % 2 == 0) {
                System.out.println(q.poll());
            } else {
                q.add(q.poll());
            }
            idx++;
        }
    }
}