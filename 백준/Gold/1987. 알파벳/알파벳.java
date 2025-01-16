import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[] visited;
	static int answer;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];
		answer = 0;
		
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		visited[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(answer);
	}
	
	static void dfs(int r, int c, int cnt) {
		answer = Math.max(answer, cnt);
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C || visited[map[nr][nc]-'A']) {
				continue;
			}
			visited[map[nr][nc]-'A'] = true;
			dfs(nr, nc, cnt+1);
			visited[map[nr][nc]-'A'] = false;
		}
	}

}