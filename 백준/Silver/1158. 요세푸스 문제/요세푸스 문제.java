import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        solution(N, K);
    }

    private static void solution(int N, int K) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int result;

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        System.out.print("<");
        while (!deque.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                int pollFirstNumber = deque.pollFirst();
                deque.addLast(pollFirstNumber);
            }
            result = deque.pollFirst();

            if(deque.size()>0) {
                System.out.print(result + ", ");
            } else {
                System.out.print(result);
            }
        }
        System.out.print(">");
    }

}
