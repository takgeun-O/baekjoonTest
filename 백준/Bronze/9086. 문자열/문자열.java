

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<T;i++) {
            String st = scanner.nextLine();
            System.out.println(st.charAt(0) + "" + st.charAt(st.length()-1));
        }
    }
}
