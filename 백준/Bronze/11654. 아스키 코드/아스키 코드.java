

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        int a = inputStream.read();
        System.out.println(a);
    }
}
