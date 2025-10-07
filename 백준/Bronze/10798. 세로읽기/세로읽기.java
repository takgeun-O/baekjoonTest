

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] matrix = new char[5][15];

        for(int i=0;i<5;i++) {
            String input = reader.readLine();
            for(int j=0;j<input.length();j++) {
                matrix[i][j] = input.charAt(j);
            }
            for(int j=input.length();j<15;j++) {
                matrix[i][j] = ' ';
            }
        }

//        for(int i=0;i<5;i++) {
//            for(int j=0;j<15;j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<15;i++) {
            for(int j=0;j<5;j++) {
                if(matrix[j][i] == ' ') {
                    continue;
                }
                sb.append(matrix[j][i]);
            }
        }

        System.out.println(sb);

    }
}


