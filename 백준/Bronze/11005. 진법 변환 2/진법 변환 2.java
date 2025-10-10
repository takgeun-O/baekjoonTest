

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {
        // 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
        // 첫 줄에 N과 B가 주어진다.
        // 첫째 줄에 10진법 수 N을 B진법으로 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 60466175 36
        // ZZZZZ

        int temp = N;
        int mod = 0;
        StringBuilder sb = new StringBuilder();
        while(true) {
            if(temp == 0) {
                break;
            }
            mod = temp % B;
            sb.append(mod).append(" ");
            temp = temp / B;
        }

//        System.out.println(sb);

        String[] arr = sb.toString().split(" ");
        String[] arrReverse = new String[arr.length];
        for(int i=0;i<arr.length;i++) {
            arrReverse[i] = arr[arr.length-i-1];
        }

//        for (String s : arrReverse) {
//            System.out.print(s);
//        }

        Map<String,String> map = new HashMap<>();
        for(int i=0;i<26;i++) {
            String key = String.valueOf(10+i);
            String value = String.valueOf((char)('A'+i));
            map.put(key, value);
        }

        StringBuilder result = new StringBuilder();
        for (String s : arrReverse) {
            if(map.containsKey(s)) {
                result.append(map.get(s));
            } else {
                result.append(s);
            }
        }

        System.out.println(result);
    }
}


