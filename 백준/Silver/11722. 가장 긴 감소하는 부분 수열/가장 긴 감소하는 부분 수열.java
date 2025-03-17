import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        ArrayList<Integer> lis = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(arr[0]);
        for(int i = 1; i < N; i++) {
            int curIdx = lis.size() - 1;
            if(lis.get(curIdx) > arr[i]) {
                lis.add(arr[i]);
            } else {
                while(lis.get(curIdx) <= arr[i]) {
                    curIdx--;
                    if(curIdx == -1) {
                        break;
                    }
                }
                lis.set(curIdx+1, arr[i]);
            }
        }
        System.out.println(lis.size());
    }
}