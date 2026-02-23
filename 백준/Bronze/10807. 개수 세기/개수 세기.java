import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String arrString = br.readLine();
        String[] line = arrString.split("\\s+");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int v = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i=0;i<N;i++) {
            if(arr[i] == v) {
                count++;
            }
        }

        System.out.println(count);
    }
}
