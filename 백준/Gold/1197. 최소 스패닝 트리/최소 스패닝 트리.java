import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] parents;
	static int[] ranks;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		parents = new int[V+1];
		ranks = new int[V+1];
		int[][] edges = new int[E][3];
		
		for(int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		// union find 연산 준비
		// ranks값 1로 초기화
		Arrays.fill(ranks, 1);
		// parents 값 자기 자신으로 초기화
		for(int i = 1; i <= V; i++) {
			makeSet(i);
		}
		
		int result = 0;
		int cnt = 0;
		for(int i = 0; i < E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if( a == b )
				continue;
			union(a,b);
			result += edges[i][2];
			cnt++;
			if( cnt == V-1 )
				break;
		}
		System.out.println(result);
		
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		} else {
			return parents[x] = findSet(parents[x]);
		}
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(ranks[px] > ranks[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if(ranks[px] == ranks[py]) {
				ranks[py]++;
			}
		}
	}
	

}