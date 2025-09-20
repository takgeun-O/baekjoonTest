

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().trim();
        scanner.close();

        if(line.isEmpty()) {
            System.out.println(0);
        } else {
            String[] words = line.split(" ");
            System.out.println(words.length);
        }


    }
}
