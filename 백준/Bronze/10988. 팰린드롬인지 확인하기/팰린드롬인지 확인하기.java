

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int flag = 0;

        // 단어 길이 짝수일 때

            for(int i=0;i<input.length()/2;i++) {
//                System.out.println(input.charAt(i) + " vs " + input.charAt(input.length()-i-1));
                if(input.charAt(i)!=input.charAt(input.length()-i-1)) {
//                    System.out.println("진입");
                    flag = 1;
                }
            }


        if(flag==1) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
