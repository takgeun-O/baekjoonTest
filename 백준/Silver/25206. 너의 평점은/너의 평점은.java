import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String, Double> gradeMap = new HashMap<>();

        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0.0;
        double creditSum = 0.0;
        for (int i = 0; i < 20; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String subject = "";
            double credit = 0;
            String grade = "";
            while (st.hasMoreTokens()) {
                subject = st.nextToken();
                credit = Double.parseDouble(st.nextToken());
                grade = st.nextToken();
            }

            if("P".equals(grade)) {
                continue;
            }
            sum = sum + credit * gradeMap.getOrDefault(grade, 0.0);
            creditSum = creditSum + credit;
        }

        System.out.println(sum / creditSum);
    }
}
