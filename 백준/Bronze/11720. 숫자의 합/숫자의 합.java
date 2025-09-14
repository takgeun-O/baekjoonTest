

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String input = scanner.nextLine();
        int sum = 0;

        for(int i=0;i<N;i++) {
            sum = sum + input.charAt(i) - '0';
        }

        System.out.println(sum);




    }
}
