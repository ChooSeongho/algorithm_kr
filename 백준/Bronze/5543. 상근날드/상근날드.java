import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int min_burger = Integer.MAX_VALUE;
        int min_drink = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++) {
            min_burger = Math.min(min_burger, Integer.parseInt(br.readLine()));
        }
        for(int i = 0; i < 2; i++) {
            min_drink = Math.min(min_drink, Integer.parseInt(br.readLine()));
        }
        br.close();
        bw.write(String.valueOf(min_burger + min_drink - 50));
        bw.flush();
        bw.close();
    }
}