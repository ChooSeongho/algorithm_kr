import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[] team1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
    static int[] team2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
    static int[][] arr;
    static int[][] res;
    static int[] answer;

    static void dfs(int tc, int play) {
        if (play == 15) {
            if (answer[tc] != 1) {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 3; j++)
                        if (arr[i][j] != res[i][j])
                            return;
                }

                answer[tc] = 1;
                return;

            } else
                return;
        }
        
        int t1 = team1[play];
        int t2 = team2[play];

       // team1 win, team2 lose
        res[t1][0]++;
        res[t2][2]++;
        dfs(tc, play + 1);
        res[t1][0]--;
        res[t2][2]--;

        // team1 draw, team2 draw
        res[t1][1]++;
        res[t2][1]++;
        dfs(tc, play + 1);
        res[t1][1]--;
        res[t2][1]--;

        // team1 lose, team2 win
        res[t1][2]++;
        res[t2][0]++;
        dfs(tc, play + 1);
        res[t1][2]--;
        res[t2][0]--;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[6][3];
        res = new int[6][3];
        answer = new int[4];

        for (int tc = 0; tc < 4; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(tc, 0);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
        	sb.append(answer[i]);
        	if(i != 3) {
        		sb.append(" ");
        	}
        }
        System.out.println(sb.toString());
    }
}