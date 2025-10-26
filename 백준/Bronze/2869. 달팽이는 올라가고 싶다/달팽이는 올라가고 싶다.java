

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A B V
        String input = br.readLine();

        // V : 나무막대 높이
        // A : 낮에 올라갈 수 있는 높이(미터)
        // B : 밤에 미끄러지는 높이(미터)
        // 정상에 올라간 후에는 미끄러지지 않음.

        StringTokenizer st = new StringTokenizer(input, " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // (0+100-99), (1+100-99), (2+100-99), (3+100-99), ...
        // Ax - Bx >= V
        // (A - B)x = V
        // x = V / (A - B)
        double x = (double)(V - A) / (A - B);

        if(x - (int)x > 0) {
            x = x + 2;
        } else {
            x = x + 1;
        }
        System.out.println((int)x);
    }
}


