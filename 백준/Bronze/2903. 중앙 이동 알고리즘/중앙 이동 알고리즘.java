

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {

        // 사각형 하나에 5개의 점 생성
        // 다만, 겹치는 부분은 뺼 필요가 있음.
        // 가로 방향 사각형에서 겹치는 점의 개수 = (가로방향 정사각형 개수 - 1) * 높이
        // 세로 방향 사각형에서 겹치는 점의 개수 = (세로방향 정사각형 개수 - 1) * 길이
        // 초기값 -> 4
        // 1단계 -> 가로방향 사각형 개수 1, 세로방향 사각형 개수 1 -> 4 + (5*4^0) - (0*1 + 0*1) = 9
        // 2단계 -> 가로방향 사각형 개수 2, 세로방향 사각형 개수 2 -> 9 + (5*4) - (1*2 + 1*2) = 25
        // 3단계 -> 가로방향 사각형 개수 4, 세로방향 사각형 개수 4 -> 25 + (5*4^2) - (3*4 + 3*4) = 25 + 80 - 24 = 81
        // 가로방향 사각형 개수 8, 세로방향 사각형 개수 8 -> 81 + (5*4^3) - (7*8 + 7*8) = 81 + 320 - 112 = 289
        // 가로방향 사각형 개수 16, 세로방향 사각형 개수 16 -> 289 + (5*4^4) - (15*16 + 15*16) = 289 + 1280 - 480 = 1089

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 4;          // 초기상태 점 4개
        int temp = 1;
        int temp2 = 1;
        int lengthCount = 1;
        int widthCount = 1;
        for(int i=0;i<N;i++) {
            if(i>0) {
                temp = temp * 4;
                temp2 = temp2 * 2;
                lengthCount = lengthCount * 2;
                widthCount = widthCount * 2;
            }
//            System.out.println(lengthCount + " " + widthCount);
//            System.out.println(temp + " " + temp2);
            count = count + (5*temp) - ((lengthCount-1)*temp2 + (widthCount-1)*temp2);
//            System.out.println(count);
        }

        System.out.print(count);
    }
}


