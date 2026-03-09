import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int start = N;

        ArrayList<Integer> list = new ArrayList<>();
        while(start != 0) {
            list.add(start % 10);
            start = start / 10;
        }

        list.sort(Collections.reverseOrder());

        for(Integer i : list) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}
