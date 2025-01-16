import java.util.*;

public class Main {
	static int W, H;
	static int[][] map;
	static boolean[][][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0,0,0,0));
		visited[0][0][0] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.r == H-1 && node.c == W-1) {
				System.out.println(node.cnt);
				return;
			}
			// k가 유효하다면 12방, 아니라면 4방
			for(int i = 0; i < (node.k < K? 12 : 4); i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				int nk = (i >= 4? node.k + 1 : node.k);
				int ncnt = node.cnt + 1;
				// 바깥세상이면 제끼고
				if(nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue;
				// 장애물이거나 같은 k회 사용으로 도달한 적이 있는 곳이면 제끼고
				if(map[nr][nc] == 1 || visited[nr][nc][nk])
					continue;
				visited[nr][nc][nk] = true;
				queue.add(new Node(nr, nc, nk, ncnt));
			}
			
		}
		System.out.println(-1);
		
	}
	
	static int[] dr = {-1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {0, 0, -1, 1, -1, 1, -2, 2, -2, 2, -1, 1};
	static class Node {
		int r,c,k,cnt;

		public Node(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}
	
}