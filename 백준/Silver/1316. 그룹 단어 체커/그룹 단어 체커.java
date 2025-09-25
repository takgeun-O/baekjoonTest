

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int N = Integer.parseInt(br.readLine());

//        3
//        happy
//        new
//        year

//        4
//        aba
//        abab
//        abcabc
//        a --> 1

        int flag = 0;
        char temp = 0;
        char c;
        for(int i=0;i<N;i++) {
            boolean[] seen = new boolean[26];
            String input = br.readLine();
//            System.out.println(input);
            for(int j=0;j<input.length();j++) {
                c = input.charAt(j);
                if(c != temp) {
                    if(seen[c-'a']) {
                        // 이전 글자와 다르면서 이미 나온 적 있는 알파벳이면 그룹문자 아닌 것
                        flag = 1;
                        break;
                    }
                }
                temp = c;
                seen[c-'a'] = true;
            }
//            System.out.println(flag);
            if(flag == 0) {
//                System.out.println(input);
                count++;
            }
            flag = 0;
            temp = 0;
        }

        System.out.println(count);


    }
}


