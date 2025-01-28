import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String num = br.readLine();

            if(num.equals("0")) {
                break;
            }

            boolean check = true;

            for(int i = 0; i <= num.length()/2; i++) {
                if(num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                    check = false;
                    break;
                }
            }
            if(check) {
                bw.write("yes");
            } else {
                bw.write("no");
            }
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();

    }
}