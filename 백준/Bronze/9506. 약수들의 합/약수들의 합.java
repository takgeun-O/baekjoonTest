

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    sum = sum + i;
                }
            }

            if(sum == n) {
                System.out.print(n + " = ");
                for(int i=0;i<list.size();i++) {
                    System.out.print(list.get(i));
                    if(i < (list.size() - 1)) {
                        System.out.print(" + ");
                    }
                }
                System.out.println();
            } else {
                System.out.println(n + " is NOT perfect.");
            }

            sum = 0;
            list.clear();
        }
    }
}


