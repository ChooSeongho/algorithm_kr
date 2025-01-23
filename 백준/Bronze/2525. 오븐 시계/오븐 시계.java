import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int hour_lim = 24;
        int minute_lim = 60;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int operating_time = Integer.parseInt(br.readLine());

        br.close();

        hour += (operating_time / minute_lim);
        minute += (operating_time % minute_lim);

        bw.write(String.valueOf((hour + (minute / minute_lim)) % hour_lim));
        bw.write(" ");
        bw.write(String.valueOf(minute % minute_lim));
        bw.flush();
        bw.close();
    }
}