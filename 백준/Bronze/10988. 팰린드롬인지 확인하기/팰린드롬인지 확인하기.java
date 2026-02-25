import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int answer = 1;
        if (line.length() % 2 == 0) {
            for (int i = 0; i < line.length() / 2; i++) {
                if (line.charAt(i) != line.charAt(line.length() - i - 1)) {
                    answer = 0;
                    break;
                }
            }
        } else {
            for (int i = 0; i < line.length() / 2 + 1; i++) {
                if (line.charAt(i) != line.charAt(line.length() - i - 1)) {
                    answer = 0;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
