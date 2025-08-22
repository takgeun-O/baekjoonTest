

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int currentH = sc.nextInt();
        int currentM = sc.nextInt();
        int requestTime = sc.nextInt();

        int transM = currentH*60 + currentM;
        int totalM = transM + requestTime;

//        System.out.println(totalM);
        System.out.println(totalM/60%24 + " " + totalM%60);


    }
}
