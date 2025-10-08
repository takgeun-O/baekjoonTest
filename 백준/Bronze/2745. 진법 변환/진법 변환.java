

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringTokenizer st = new StringTokenizer(input);

        String N = st.nextToken();
        int length = N.length();
        int B = Integer.parseInt(st.nextToken());

        // ABCDEFGHIJKLMNOPQRSTUVWXYZ 총 26개
        // ZZZZZ 36
        // A 는 10, B는 11, ... Z는 35
        // 35*36^4 + 35*36^3 + 35*36^2 + 35*36^1 + 35*36^0

        Map<String, Integer> map = new HashMap<>();

//        String x = String.valueOf((char)('0' + 1));
//        System.out.println(x);
        for(int i=0;i<=9;i++) {
            String x = String.valueOf((char)('0' + i));
            map.put(x,i);
        }

        for(int i=0;i<26;i++) {
            String x = String.valueOf((char)('A' + i));
            map.put(x, i+10);
        }

//        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
//            System.out.println(stringIntegerEntry);
//        }

        Integer total = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++) {
            Integer digit = map.get(String.valueOf(N.charAt(i)));
            Integer result = digit;
            for(int j=0;j<length-1-i;j++) {
                result = result * B;
            }
//            System.out.println(result);
            total = total + result;
        }

        System.out.println(total);
    }
}


