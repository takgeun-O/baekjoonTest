import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        String[] inputArr = input.split("\\s+");

        int N = Integer.parseInt(inputArr[0]);
        int B = Integer.parseInt(inputArr[1]);

        String result;

        while(N != 0) {

            int value = N % B;

            if(value >= 0 && value <= 9) {
                sb.append((char)('0' + value));
            } else {
                sb.append((char)('A' + (value - 10)));
            }

            N = N / B;
        }

        System.out.println(sb.reverse());
    }
}
