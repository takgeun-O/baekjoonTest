

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = new int[9][9];

        int max = 0;
        int maxRow = 0;
        int maxCol = 0;

        for(int i=0;i<9;i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j=0;j<9;j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(max < matrix[i][j]) {
                    maxRow = i;
                    maxCol = j;
                    max = matrix[i][j];
                }
            }
        }

        System.out.println(max);
        System.out.print((maxRow+1) + " " + (maxCol+1));


    }
}


