import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        for(int i=0;i<5;i++) {
            sum = sum + arr[i];
        }

        int avg = sum / 5;
        int mid = arr[2];

        sb.append(avg).append('\n').append(mid);

        System.out.print(sb);
    }
}
