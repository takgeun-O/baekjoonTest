import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a_1 = Integer.parseInt(st.nextToken());
        int a_0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n_0 = Integer.parseInt(br.readLine());

        int resultFn = a_1 * n_0 + a_0;
        int resultcGn = c * n_0;

        if(a_1 <= c && resultFn <= resultcGn) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
