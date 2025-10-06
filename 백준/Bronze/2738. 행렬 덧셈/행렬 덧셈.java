

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        // 행렬A
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬B
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumArray = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                sumArray[i][j] = A[i][j] + B[i][j];
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                System.out.print(sumArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}


