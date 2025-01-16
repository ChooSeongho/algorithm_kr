import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int cnt;
		Point(int x) {
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N));
		visited[N] = true;
		
		int answer = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == K) {
				answer = Math.min(answer, p.cnt);
			}
			for(int i = -1; i < 3; i++) {
				int dx = p.x + i;
				if(i == 2) {
					dx = p.x * 2;
				}
				if(dx < 0 || dx > 100000 || visited[dx]) {
					continue;
				}
				visited[dx] = true;
				Point next = new Point(dx);
				next.cnt = p.cnt + 1;
				queue.add(next);
			}
		}
		
		System.out.println(answer);
		
	}
}