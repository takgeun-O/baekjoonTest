

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        // 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → …

        // 짝수번 횟수로 처음 시작할 때 분모는 +1하면서 시작하고 진행 시 분자는 증가, 분모는 감소
        // 홀수번 횟수로 처음 시작할 때 분자는 +1하면서 시작하고 진행 시 분자는 감소, 분모는 증가

        // 한 바퀴가 종료되는 횟수 -> 1, 2, 4, 7, 11, 16, ....
        // b_n = 1 + (n-1)*1 = n
        // a_n = 1 + n(n-1)/2 = 1 + (n^2-n)/2 = (n^2-n)/2 + 1

        int numerator = 1;
        int denominator = 1;
        int n = 1;
        int flag = 1;          // 1이면 가로방향, -1이면 세로방향
        int flag2 = 0;
        for(int i=1;i<=X;i++) {

            if(i==(n*n-n)/2+1) {          // 전환점
                flag = flag * -1;
                n++;
                flag2 = 1;
            }

            if(i!=1 && flag2==1) {              // 끄트머리
                if(flag==1) {
                    denominator++;
                } else if(flag==-1) {
                    numerator++;
                }
            }

            if(i!=1 && flag2==0) {              // 진행 중
                if(flag==1) {
                    numerator++;
                    denominator--;
                } else if(flag==-1){
                    numerator--;
                    denominator++;
                }
            }

//            System.out.println(numerator + "/" + denominator);

            flag2 = 0;
        }

        System.out.println(numerator + "/" + denominator);
    }
}


