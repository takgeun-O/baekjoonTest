

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {
        // 도화지 크기 가로세로 각각 100 정사각형 // 색종이는 가로세로 각 10 정사각형
        // 색종이 시작과 끝 부분은 +1 표시, 오른쪽 상단과 왼쪽 하단은 -1 표시
        // 각 행에서 왼쪽에서 오른쪽으로 누적합
        // 각 열에서 위에서 아래로 누적합
        // 도화지 위에서 1 이상인 것의 개수 출력

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] diff = new int[101][101];

        int count = Integer.parseInt(reader.readLine());

        for(int i=0;i<count;i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            diff[a][b] = diff[a][b] + 1;
            diff[a+10][b] = diff[a+10][b] - 1;
            diff[a][b+10] = diff[a][b+10] - 1;
            diff[a+10][b+10] = diff[a+10][b+10] + 1;
        }

//        for(int i=0;i<=100;i++) {
//            for(int j=0;j<=100;j++) {
//                System.out.print(diff[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();

        for(int i=0;i<=100;i++) {
            for(int j=1;j<=100;j++) {
                diff[i][j] = diff[i][j] + diff[i][j-1];
            }
        }

        for(int j=0;j<=100;j++) {
            for(int i=1;i<=100;i++) {
                diff[i][j] = diff[i][j] + diff[i-1][j];
            }
        }

//        for(int i=0;i<=100;i++) {
//            for(int j=0;j<=100;j++) {
//                System.out.print(diff[i][j]);
//            }
//            System.out.println();
//        }

        int sum = 0;
        for(int i=0;i<=100;i++) {
            for(int j=0;j<=100;j++) {
                if(diff[i][j] > 0) {
                    sum = sum + 1;
                }
            }
        }

        System.out.print(sum);
    }
}


