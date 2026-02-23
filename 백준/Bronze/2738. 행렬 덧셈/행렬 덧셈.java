import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N, M;

        N = sc.nextInt();
        M = sc.nextInt();

        int[][] arrA = new int[N][M];
        int[][] arrB = new int[N][M];

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                arrA[i][j] = sc.nextInt();
            }
        }

        int[][] sumArr = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                arrB[i][j] = sc.nextInt();
                sumArr[i][j] = arrA[i][j] + arrB[i][j];
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                System.out.print(sumArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
