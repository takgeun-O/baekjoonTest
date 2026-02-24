import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                stack.pop();
                continue;
            }
            stack.push(n);
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum = sum + stack.pop();
        }

        System.out.println(sum);
    }
}
