import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int[] list = {25, 10, 5, 1};        // 센트 단위
        int[] result = new int[4];

        int T = sc.nextInt();

        for(int i=0;i<T;i++) {
            int C = sc.nextInt();
            for(int j=0;j<4;j++) {
                int count = C / list[j];
                result[j] = count;
                C = C - list[j] * count;
            }

            for(int j=0;j<4;j++) {
                System.out.print(result[j] + " ");
            }
        }

    }
}
