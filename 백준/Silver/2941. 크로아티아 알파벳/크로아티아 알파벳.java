

import java.io.*;
import java.util.*;

public class Main {

    // 흰색 킹, 퀸, 룩, 비숍, 나이트, 폰
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // ljes=njak --> 6
        String input = reader.readLine();
        String[] inputArr = new String[input.length()];
        for(int i=0;i<input.length();i++) {
            inputArr[i] = String.valueOf(input.charAt(i));
        }

//        System.out.println(input.indexOf("nj"));

        int startIndex = 0;
        int sum = 0;
        int arrLength = 0;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< inputArr.length;i++) {
            sb.append(inputArr[i]);
            sum++;
            for(int j=0;j<arr.length;j++) {
                if(sb.toString().contains(arr[j])) {
//                    System.out.println(sb);
                    arrLength = arr[j].length();                // 2, 2, 2
                    sum = sum - arrLength + 1;                  // 1,
                    sb.setLength(0);
                    break;
                }
            }
        }

        System.out.println(sum);


    }
}


