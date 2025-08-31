

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] basket = new int[N];
        for(int idx=0;idx<N;idx++) {
            basket[idx] = idx+1;                // 바구니 번호 설정
        }

        int i,j;
        for(int count=0;count<M;count++) {
            i = scanner.nextInt();
            j = scanner.nextInt();

            int[] tempArr = new int[j-i+1];

            for(int tempIdx=0;tempIdx<tempArr.length;tempIdx++) {           // 임시 배열에 옮기기
                tempArr[tempIdx] = basket[j-1-tempIdx];
            }

//            for(int x=0;x< tempArr.length;x++) {
//                System.out.print(tempArr[x] + " ");
//            }
//            System.out.println();

            int tempIdx = 0;
            for(int idx=i-1;idx<=j-1;idx++) {
                basket[idx] = tempArr[tempIdx++];
            }

//            for(int x=0;x< basket.length;x++) {
//                System.out.print(basket[x] + " ");
//            }
//            System.out.println();
        }

        for(int x=0;x< basket.length;x++) {
            System.out.print(basket[x] + " ");
        }


    }
}
