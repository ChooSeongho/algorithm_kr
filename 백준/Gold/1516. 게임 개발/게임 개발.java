import java.util.*;

public class Main {
	static class Build {
		int idx;
		int cnt;
		int prevCnt;
		ArrayList<Build> prev;
		Build(int idx) {
			this.idx = idx;
			prev = new ArrayList<Build>();
		}
	}
	static int N;
	static ArrayList<Build> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList<Build>();
		list.add(new Build(0));
		int[] prevCnt = new int[N+1]; // 이전에 건설해야하는 건물 수
		for(int i = 1; i <= N; i++) {
			list.add(new Build(i));
		}
		
		for(int i = 1; i <= N; i++) {
			list.get(i).cnt = sc.nextInt();
			int prev = sc.nextInt(); 
			while(prev != -1) {
				list.get(prev).prev.add(list.get(i));
				prevCnt[i]++;
				prev = sc.nextInt();
			}
		}
		Queue<Build> q = new LinkedList<Build>();
		
		for(int i = 1; i <=N; i++) {
			if(prevCnt[i] == 0) {
				q.add(list.get(i));
			}
		}
		
		while(!q.isEmpty()) {
			Build tmpN = q.poll();
			for(int i = 0; i < tmpN.prev.size(); i++) {
				Build nextN = tmpN.prev.get(i);
				// 연결된 간선 수 감소
				prevCnt[nextN.idx]--;
				nextN.prevCnt = Math.max(nextN.prevCnt, (tmpN.cnt+tmpN.prevCnt));
				
				// 이전에 건설해야하는 건물을 모두 건설한 후 큐에 추가 
				if(prevCnt[nextN.idx] == 0) {
					q.add(nextN);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(list.get(i).cnt + list.get(i).prevCnt);
		}
		
//		for(int i = 1; i <= N; i++) {
//			list.get(i).cnt = sc.nextInt();
//			int next = sc.nextInt(); 
//			while(next != -1) {
//				list.get(i).prev.add(list.get(next));
//				next = sc.nextInt();
//			}
//		}
//		
//		for(int i = 1; i <= N; i++) {
//			ArrayList<Build> tmp = list.get(i).prev;
//			int sum = 0;
//			if(tmp.size() > 0) {
//				Queue<Build> q = new LinkedList<Build>();
//				boolean[] visited = new boolean[N+1];
//				visited[list.get(i).idx] = true;
//				for(Build b : tmp) {	
//					q.add(b);
//					visited[b.idx] = true;
//				}
//				while(!q.isEmpty()) {
//					Build tmpB = q.poll();
//					sum += tmpB.cnt;
//					if(tmpB.prev.size() > 0) {
//						for(Build b : tmpB.prev) {
//							if(!visited[b.idx]) {								
//								visited[b.idx] = true;
//								q.add(b);
//							}
//						}
//					}
//				}
//			}
//			sum += list.get(i).cnt;
//			System.out.println(sum);
//		}
		
	}

}