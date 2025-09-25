

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        // 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값

        // 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();

        // 과목평점표 구성
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        double sum1 = 0;    // (학점*과목평점)의 총합
        double sum2 = 0;    // 학점의 총합
        String grade;
        double gradeScore = 0;
        double credit;

        for(int i=0;i<20;i++) {
            String input = reader.readLine();
            String[] parts = input.split(" ");
            grade = parts[2];
            if(grade.equals("P")) {
                continue;
            }
            credit = Double.parseDouble(parts[1]);
            gradeScore = map.get(grade);
//            System.out.println(credit + " " + grade + " " + gradeScore);
            sum1 = sum1 + (credit*gradeScore);
            sum2 = sum2 + credit;
        }

        System.out.println(sum1 / sum2);

    }
}


