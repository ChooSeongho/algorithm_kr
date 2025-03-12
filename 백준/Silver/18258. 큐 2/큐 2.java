import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<Integer>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                q.offer(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("pop")) {
                bw.write(q.isEmpty()? "-1" : String.valueOf(q.poll()));
                bw.newLine();
            } else if(cmd.equals("size")) {
                bw.write(String.valueOf(q.size()));
                bw.newLine();
            } else if(cmd.equals("empty")) {
                bw.write(q.isEmpty()? "1" : "0");
                bw.newLine();
            } else if(cmd.equals("front")) {
                bw.write(q.isEmpty()? "-1" : String.valueOf(q.peek()));
                bw.newLine();
            } else if(cmd.equals("back")) {
                bw.write(q.isEmpty()? "-1" : String.valueOf(q.peekLast()));
                bw.newLine();
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}