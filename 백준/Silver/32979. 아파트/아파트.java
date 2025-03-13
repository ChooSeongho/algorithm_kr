import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < T; i++) {
            int b = Integer.parseInt(st1.nextToken());
            while(--b > 0) {
                q.add(q.poll());
            }
            bw.write(q.peek()+" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
