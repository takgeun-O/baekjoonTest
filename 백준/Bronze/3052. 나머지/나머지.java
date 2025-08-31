

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        int inputNum;
        int count=0;

        for(int i=0;i<10;i++) {
            inputNum = scanner.nextInt();
            arr[i] = inputNum % 42;
        }


        for(int i=0;i<10;i++) {
            if(arr[i]>=0) {
                count++;
                for (int j = i + 1; j < 10; j++) {
                    if (arr[i] == arr[j]) {
                        arr[j] = -1;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
