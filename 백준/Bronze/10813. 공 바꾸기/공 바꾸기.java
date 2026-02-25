import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bucket = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            bucket[i] = i;
        }

        int temp = 0;
        for (int c = 0; c < M; c++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            temp = bucket[i];
            bucket[i] = bucket[j];
            bucket[j] = temp;
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(bucket[i]).append(" ");
        }

        System.out.println(sb);
    }
}
