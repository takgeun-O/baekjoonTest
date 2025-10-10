

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {
        // 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
        // 첫 줄에 N과 B가 주어진다.
        // 첫째 줄에 10진법 수 N을 B진법으로 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 60466175 36
        // ZZZZZ

        if (N == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int r = N % B;
            char c = r < 10 ? (char)('0'+r) : (char) ('A'+(r-10));
            sb.append(c);
            N = N / B;
        }

        System.out.println(sb.reverse());
    }
}


