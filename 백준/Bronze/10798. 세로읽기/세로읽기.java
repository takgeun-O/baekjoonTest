

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = new String[5];
        int[] len = new int[5];
        int maxLen = 0;

        for(int i=0;i<5;i++) {
            lines[i] = reader.readLine();
            len[i] = lines[i].length();
            if(maxLen < len[i]) {
                maxLen = len[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int col=0;col<maxLen;col++) {
            for(int row=0;row<5;row++) {
                if(col < lines[row].length()) {
                    sb.append(lines[row].charAt(col));
                }
            }
        }

        System.out.println(sb);

    }
}


