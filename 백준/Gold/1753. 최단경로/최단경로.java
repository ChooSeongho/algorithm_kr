import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start_node = Integer.parseInt(br.readLine()) - 1;

        ArrayList<Node>[] nodes = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            StringTokenizer temp_st = new StringTokenizer(br.readLine());
            nodes[Integer.parseInt(temp_st.nextToken()) - 1].add(
                    new Node(Integer.parseInt(temp_st.nextToken()) -1,
                            Integer.parseInt(temp_st.nextToken())));
        }
        br.close();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V];
        Node[] D = new Node[V];
        for(int i = 0; i < V; i++) {
            if(i == start_node) {
                D[i] = new Node(i, 0);
            } else {
                D[i] = new Node(i, Integer.MAX_VALUE);
            }
            pq.add(D[i]);
        }

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.weight == Integer.MAX_VALUE) {
                break;
            }
            for(Node next : nodes[node.idx]) {
                if(!check[next.idx] && D[next.idx].weight > D[node.idx].weight + next.weight) {
                    D[next.idx].weight = D[node.idx].weight + next.weight;
                    pq.remove(D[next.idx]);
                    pq.add(D[next.idx]);
                }
            }
            check[node.idx] = true;
        }

        for(int i = 0; i < V; i++) {
            if(D[i].weight == Integer.MAX_VALUE) {
                bw.write("INF");
            } else {
                bw.write(String.valueOf(D[i].weight));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static class Node implements Comparable<Node> {
        int idx;
        int weight;
        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}