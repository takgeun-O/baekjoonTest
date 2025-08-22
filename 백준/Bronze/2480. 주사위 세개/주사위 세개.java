

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] v = new int[3];
        int max=0;
        int count=0;
        int sameV=0;

        for(int i=0;i<3;i++) {
            v[i] = sc.nextInt();
        }

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(v[i]==v[j]) {
                    count++;
                    sameV = v[i];
                }
            }
            if(v[i]>max) {
                max = v[i];
            }

            if(count==3) {
                System.out.println(10000+sameV*1000);
                break;
            } else if(count==2) {
                System.out.println(1000+sameV*100);
                break;
            }

            count=0;
        }

        if(count==0) {
            System.out.println(max*100);
        }


    }
}
