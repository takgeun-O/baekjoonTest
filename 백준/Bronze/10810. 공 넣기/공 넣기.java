import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bucket = new int[N];
        for (int a = 0; a < M; a++) {
            line = br.readLine();
            st = new StringTokenizer(line);

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

//            System.out.println(i + " " + j + " " + k);
            for (int b = i - 1; b <= j - 1; b++) {
                bucket[b] = k;
            }
        }

        for(int i=0;i<N;i++) {
            sb.append(bucket[i]).append(" ");
        }

        System.out.println(sb);
    }
}
