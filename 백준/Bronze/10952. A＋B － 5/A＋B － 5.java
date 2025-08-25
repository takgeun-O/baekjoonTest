

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(;;) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            if(A==0 && B==0) {
                break;
            }
            System.out.println(A+B);
        }
    }
}
