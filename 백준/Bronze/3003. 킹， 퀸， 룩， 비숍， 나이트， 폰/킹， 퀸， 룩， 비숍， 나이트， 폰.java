import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] correct = {1, 1, 2, 2, 2, 8};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        StringBuilder sb = new StringBuilder();

        int[] given = new int[6];
        int i = 0;
        while(st.hasMoreTokens()) {
            given[i++] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[6];
        for(int index=0;index<correct.length;index++) {
            answer[index] = correct[index] - given[index];
        }

        for(int index=0;index<6;index++) {
            sb.append(answer[index]).append(" ");
        }

        System.out.println(sb);
    }
}
