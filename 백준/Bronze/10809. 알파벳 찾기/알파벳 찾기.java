

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for(int i='a';i<='z';i++) {
            System.out.print(input.indexOf(i) + " ");
        }




    }
}
