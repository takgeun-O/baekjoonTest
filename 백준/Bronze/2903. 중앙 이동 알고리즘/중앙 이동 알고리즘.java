import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int add = 1;
        int count = 0;
        for(int i=0;i<N;i++) {
            if(i==0) {
                count = 3;
            } else {
                add = add * 2;
                count = count + add;
            }
        }

        System.out.println(count*count);
    }
}
