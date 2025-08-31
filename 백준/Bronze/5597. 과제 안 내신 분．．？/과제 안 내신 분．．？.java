

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] students = new int[30];
        int studentNumber = 0;

        for(int i=0;i<28;i++) {
            studentNumber = scanner.nextInt();        // 과제 제출자 번호
            students[studentNumber-1] = 1;            // 과제 제출한 애는 1 넣기
        }

        for(int i=0;i<30;i++) {
            if(students[i]==0) {
                System.out.println(i+1);
            }
        }
    }
}
