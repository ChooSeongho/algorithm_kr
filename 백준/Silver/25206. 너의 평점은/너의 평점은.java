import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 20;
        HashMap<String, Float> record_map = new HashMap<>();
        record_map.put("A+", 4.5f);
        record_map.put("A0", 4.0f);
        record_map.put("B+", 3.5f);
        record_map.put("B0", 3.0f);
        record_map.put("C+", 2.5f);
        record_map.put("C0", 2.0f);
        record_map.put("D+", 1.5f);
        record_map.put("D0", 1.0f);
        record_map.put("F", 0.0f);
        float res = 0;
        float grade_count = 0;

        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String sub = st.nextToken();
            float grade = Float.parseFloat(st.nextToken());
            String record = st.nextToken();
            grade_count += grade;
            if("P".equals(record)) {
                grade_count -= grade;
                continue;
            } else {
                res += (grade * record_map.get(record));
            }
        }
        System.out.println(res / grade_count);
    }
}