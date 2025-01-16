import java.util.*;

public class Main {
	static class Point {
		int r;
		int c;
		int key;
		int cnt;
		Point(int r, int c, int key, int cnt) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
	}
	static int R;
	static int C;
	static char[][] map;
	static boolean[][][] visited;
	static int answer;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int r = 0;
		int c = 0;
		map = new char[R][C]; 
		visited = new boolean[R][C][(1 << 6)+0x1];
		answer = Integer.MAX_VALUE;
		for(int i = 0; i < R; i++) {
			String str = sc.next();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					r = i;
					c = j;
				}
			}
		}
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c, 0, 0));
		visited[r][c][0] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int tmpR = tmp.r;
			int tmpC = tmp.c;
			int tmpCnt = tmp.cnt;
			
			if(map[tmpR][tmpC] == '1') {
				answer = Math.min(answer, tmpCnt);
				continue;
			}
			
			for(int i = 0; i < dr.length; i++) {
				int nr = tmpR+dr[i];
				int nc = tmpC+dc[i];
				int key = tmp.key;
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
					continue;
				}
				
				if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					key = key | (1 << (map[nr][nc] - 'a'));
				}
				
				if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F' && (key & (1 << (map[nr][nc] -'A'))) == 0) {
					continue;
				}
				
				if(visited[nr][nc][key]) {
					continue;
				}
				
				if(map[nr][nc] != '#') {
					q.add(new Point(nr, nc, key, tmpCnt+1));
					visited[nr][nc][key] = true;
				}
			}
			
		}
		
		System.out.println((answer == Integer.MAX_VALUE)? -1 : answer);
	}
	
}