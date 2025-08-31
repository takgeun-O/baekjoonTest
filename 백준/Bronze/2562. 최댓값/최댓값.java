

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[9];

        for(int i=0;i<9;i++) {
            arr[i] = scanner.nextInt();
        }

        int max = arr[0];
        int idx = 0;
        for(int i=0;i<9;i++) {
            if(arr[i]>max) {
                max = arr[i];
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx+1);
    }
}
