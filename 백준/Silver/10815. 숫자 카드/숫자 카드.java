import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            bw.write(Arrays.binarySearch(arr, key) >= 0? "1 " : "0 ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}