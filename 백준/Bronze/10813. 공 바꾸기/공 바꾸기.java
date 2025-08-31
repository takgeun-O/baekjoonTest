

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();          // 바구니 개수
        int M = scanner.nextInt();          // 공 바꿀 횟수

        int i, j;
        int[] basket = new int[N];

        for(int idx=0;idx<N;idx++) {
            basket[idx] = idx+1;            // 바구니번호와 같은 번호의 공
        }

        int temp = 0;
        for(int count=0;count<M;count++) {
            i = scanner.nextInt();
            j = scanner.nextInt();

            temp = basket[i-1];
            basket[i-1] = basket[j-1];
            basket[j-1] = temp;
        }

        for(int idx=0;idx<N;idx++) {
            System.out.print(basket[idx] + " ");
        }
    }
}
