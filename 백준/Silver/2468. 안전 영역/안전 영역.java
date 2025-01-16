import java.util.*;

public class Main {
	static class Point {
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] map;
	static int max;
	static int answer;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		answer = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		
//		for(int i = 0; i < max; i++) {
//			bfs(i);
//		}
		
		for(int r = 0; r < max; r++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {				
					if(!visited[i][j] && map[i][j] > r) {
						dfs(i,j,r);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);

	}
	
	static void bfs(int rain) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][] visited = new boolean[N][N];
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] > rain && !visited[i][j]) {
					queue.add(new Point(i,j));
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						Point tmpP = queue.poll();
						for(int k = 0; k < 4; k++) {
							int nr = tmpP.r + dr[k];
							int nc = tmpP.c + dc[k];
							if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) {
								continue;
							}
							if(map[nr][nc] > rain) {								
								queue.add(new Point(nr,nc));
								visited[nr][nc] = true;
							}
							
						}
					}
					cnt++;
				}
			}
		}
		
		answer = Math.max(answer, cnt);
		
	}
	
	static void dfs(int r, int c, int rain) {
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) {
				continue;
			}
			if(map[nr][nc] > rain) {
				dfs(nr, nc, rain);
			}
		}
		
	}
	

}