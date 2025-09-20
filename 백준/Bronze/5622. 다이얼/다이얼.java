

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};      // 3초 4초 5초 ...

        String input = br.readLine();
        int sum = 0;
        int targetIndex = 0;

        for(int i=0;i<input.length();i++) {
            char target = input.charAt(i);
            for(int j=0;j<arr.length;j++) {
                int flag = arr[j].indexOf(target);          // 못 찾으면 -1, 찾으면 인덱스 반환
                if(flag!=-1) {
                    targetIndex = j;
                    break;
                }
            }
            sum = sum + targetIndex + 3;
        }

        System.out.println(sum);

    }
}
