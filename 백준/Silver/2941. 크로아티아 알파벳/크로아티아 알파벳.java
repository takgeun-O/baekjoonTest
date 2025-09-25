

import java.io.*;
import java.util.*;

public class Main {

    // 흰색 킹, 퀸, 룩, 비숍, 나이트, 폰
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

        String input = br.readLine();

        for (String s : arr) {
            input = input.replace(s, "*");
        }
//        System.out.println(input);
        System.out.println(input.length());


    }
}


