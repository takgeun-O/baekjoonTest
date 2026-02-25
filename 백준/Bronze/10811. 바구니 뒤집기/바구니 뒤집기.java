import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bucket = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            bucket[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= (b - a) / 2; j++) {
                int temp = bucket[a + j];
                bucket[a + j] = bucket[b - j];
                bucket[b - j] = temp;
            }
//            for (int j = 1; j <= N; j++) {
//                System.out.print(bucket[j] + " ");
//            }
//            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            sb.append(bucket[i]).append(" ");
        }

        System.out.println(sb);
    }
}
