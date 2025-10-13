

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 거리 1 -> 2 ~ 7번방 -> 6개
        // 거리 2 -> 8 ~ 19번방 -> 12개
        // 거리 3 -> 20 ~ 37번방 -> 18개
        // 거리 4 -> 38 ~ 61번방 -> 24개

        // a_1 = 2, a_n+1 = a_n + 6n
        // a_n = a_1 + 6*n(n-1)/2
        // a_n = 3n^2 - 3n + 2

        int result = 0;
        int i = 1;

        if(N==1) {
            System.out.print(1);
        } else {
            while (true) {
                result = 3 * i * i - 3 * i + 2;
                if (N >= result && N <= result + 6 * i - 1) {
                    break;
                }
                i++;
            }

            System.out.print(i + 1);
        }

    }
}


