import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean[] teams;
	static boolean[] finished;
	static int[] arr;
	static int N;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			teams = new boolean[N+1];
			finished = new boolean[N+1];
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N+1];
			for(int i = 1; i <= N; i++) {
				int d = Integer.parseInt(st.nextToken());
				arr[i] = d;
			}
			
			for(int i = 1; i <= N; i++) {
				if(!finished[i]) {
					dfs2(i);
				}
//				if(!teams[i]) {
//					teams[i] = true;
//					dfs(i, i, 1, new int[N+1]);
//				}
				
			}
			
			bw.write((N-answer)+"\n");
			bw.flush();
			
		}
		bw.close();
	}
	
	static void dfs2(int idx) {
		if(teams[idx]) {
			return;
		}
		teams[idx] = true;
		int next = arr[idx];
		
		if(!teams[next]) {
			dfs2(next);
		} else {
			if(!finished[next]) {
				for(int i = next; i != idx; i = arr[i]) {
					answer++;
				}
				answer++;
			}
		}
		
		finished[idx] = true;
		
	}
	
	static void dfs(int idx, int start, int cnt, int[] sel) {
		int next = arr[idx];
		if(next == start) {
			for(int i = 0; i < cnt-1; i++) {
				teams[sel[i]] = true;
			}
			answer += cnt;
			return;
		}
		if(!teams[next]) {
			teams[next] = true;
			sel[cnt-1] = next;
			dfs(next, start, cnt+1, sel);
			teams[next] = false;
		}
		
	}

}