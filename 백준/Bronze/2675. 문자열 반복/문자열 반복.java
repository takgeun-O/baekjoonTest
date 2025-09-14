

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            String[] parts = br.readLine().split(" ");
            int iter = Integer.parseInt(parts[0]);

            for(int j=0;j<parts[1].length();j++) {
                for(int k=0;k<iter;k++) {
                    System.out.print(parts[1].charAt(j));
                }
            }
            System.out.println();
        }

    }
}
