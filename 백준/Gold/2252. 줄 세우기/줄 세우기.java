import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] edgeCnt = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int taller = Integer.parseInt(st.nextToken());
			int smaller = Integer.parseInt(st.nextToken());
			edgeCnt[smaller]++;
			list[taller].add(smaller);
		}
		
		Queue<Integer> q = new LinkedList<>();		
		for(int i = 1; i <= N; i++) {
			if(edgeCnt[i] == 0) {
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur);
			sb.append(" ");
			for(int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(--edgeCnt[next] == 0) {
					q.add(next);
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}