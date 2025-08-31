

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();      // 바구니 수
        int M = scanner.nextInt();      // 공 넣는 횟수

        int[] basketArr = new int[N];
        int i,j,k;

        for(int count=0;count<M;count++) {
            i = scanner.nextInt();
            j = scanner.nextInt();
            k = scanner.nextInt();

            for(int idx=i;idx<=j;idx++) {
                basketArr[idx-1] = k;
            }

//            for(int idx=0;idx<N;idx++) {
//                System.out.print(basketArr[idx] + " ");
//            }
        }

        for(int idx=0;idx<N;idx++) {
            System.out.print(basketArr[idx] + " ");
        }
    }
}
