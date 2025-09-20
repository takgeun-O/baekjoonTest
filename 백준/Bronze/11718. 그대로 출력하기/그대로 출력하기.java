

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        // EOF까지
        while((line=br.readLine()) != null) {
            sb.append(line).append("\n");
        }

        System.out.println(sb.toString());
    }
}
