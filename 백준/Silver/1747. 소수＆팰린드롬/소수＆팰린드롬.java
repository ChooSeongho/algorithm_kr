import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        br.close();
        int N = 1000000;
        boolean[] checked = new boolean[N+1];
        checked[0] = true;
        checked[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(checked[i]) {
                continue;
            }

            for(int j = i * i; j <= N; j+=i) {
                checked[j] = true;
            }
        }

        int idx = 0;
        while(true) {
            if(idx > N) {
                N *= 2;
                checked = renewChecked(checked, N);
            }

            if(!checked[idx]) {
                boolean check = true;
                char[] temp_str = String.valueOf(idx).toCharArray();
                for(int i = 0; i <= temp_str.length/2; i++) {
                    if(temp_str[i] != temp_str[temp_str.length - 1 - i]) {
                        check = false;
                        break;
                    }
                }
                if(check && idx >= target) {
                    bw.write(String.valueOf(idx));
                    break;
                }
            }
            idx++;
        }
        bw.flush();
        bw.close();
    }

    private static boolean[] renewChecked(boolean[] old_checked, int target) {
        boolean[] new_checked = new boolean[target+1];
        System.arraycopy(old_checked, 0, new_checked, 0, old_checked.length);
        for(int i = 2; i <= Math.sqrt(target); i++) {
            if(new_checked[i]) {
                continue;
            }

            for(int j = i * i; j <= target; j+=i) {
                new_checked[j] = true;
            }
        }
        return new_checked;
    }

}