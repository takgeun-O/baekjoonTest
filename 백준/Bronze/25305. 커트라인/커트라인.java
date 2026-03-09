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
        int k = Integer.parseInt(st.nextToken());

        Integer[] score = new Integer[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score, Collections.reverseOrder());
//        for(int i=0;i<N;i++) {
//            System.out.print(score[i] + " ");
//        }
//        System.out.println();

        sb.append(score[k-1]);

        System.out.println(sb);
    }
}
