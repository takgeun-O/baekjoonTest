import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 28; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.add(x);
        }

//        while(!pq.isEmpty()) {
//            System.out.println(pq.poll());
//        }

        for(int i=1;i<=30;i++) {
            if(!pq.contains(i)) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
