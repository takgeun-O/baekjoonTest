

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

//        10-45 = -35 + 60 = 25
        if(H>=0 && (M-45>=0)) {
            System.out.println(H + " " + (M-45));
        } else if(H>0 && (M-45<0)) {
            System.out.println((H-1) + " " + (M-45+60));
        } else if(H==0 && (M-45<0)) {
            System.out.println((23-H) + " " + (M-45+60));
        }
    }
}
