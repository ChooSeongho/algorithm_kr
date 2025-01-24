import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int year = Integer.parseInt(st.nextToken());
        int showed_num = Integer.parseInt(st.nextToken())-1;

        bw.write("SN " + year);
        int div_num = showed_num / 26;
        int remain_num = showed_num % 26;
        if(div_num > 0) {
            bw.write('a' + (div_num-1));
            bw.write('a' + (remain_num));
        } else {
            bw.write('A' + (remain_num));
        }
        bw.flush();
        bw.close();
    }

}

