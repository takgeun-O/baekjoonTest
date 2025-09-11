

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        InputStreamReader sr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(sr);
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            String s = br.readLine();

            char first = s.charAt(0);
            char last = s.charAt(s.length()-1);

            sb.append(first).append(last).append("\n");
        }

        System.out.println(sb.toString());
    }
}
