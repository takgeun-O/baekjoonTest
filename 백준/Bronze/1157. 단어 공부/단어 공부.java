

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();


        String upperString = input.toUpperCase();
        int[] cnt = new int[26];

        for (int i = 0; i < upperString.length(); i++) {
            char c = upperString.charAt(i);
            cnt[c - 'A']++;
        }

//        for (int value : cnt) {
//            bw.write(String.valueOf(value));
//        }
//
//        bw.flush();

        int max = 0;
        int flag = 0;
        char maxChar;
        int maxIndex = 0;
        for(int i=0;i<cnt.length;i++) {
            if(cnt[i] == max) {
                flag = 1;
            }
            if(cnt[i] > max) {
                max = cnt[i];
                maxIndex = i;
                flag = 0;       // 갱신되면 내리기
            }
        }

//        System.out.println(maxIndex);

        if(flag==0) {
            // 0이면 A 1이면 B ....
            bw.write('A' + maxIndex);
            bw.flush();
        } else {
            bw.write("?");
            bw.flush();
        }
    }
}


