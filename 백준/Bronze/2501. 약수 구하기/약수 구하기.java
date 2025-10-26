

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;
        int count = 0;
        int flag = 0;
        for(int i=1;;i++) {
            if(i > N) {
                break;
            }
            if(N % i == 0) {
                count++;
                if(count == K) {
                    System.out.println(i);
                    flag = 1;
                    break;
                }
            }
        }

        if(flag == 0) {
            System.out.println(0);
        }
    }
}


