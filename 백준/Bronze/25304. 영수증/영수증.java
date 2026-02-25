import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int total = 0;
        for(int i=0;i<N;i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int a = 0;
            int b = 0;
            while(st.hasMoreTokens()) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
            }
            total = total + a * b;
        }

        if(X==total) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
