

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] correctArr = {1, 1, 2, 2, 2, 8};
        int[] arr = new int[6];
        int index = 0;

        while(st.hasMoreElements()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[6];

        for(int i=0;i<6;i++) {
            result[i] = correctArr[i] - arr[i];
        }

        for(int value : result) {
            System.out.print(value + " ");
        }

    }
}
