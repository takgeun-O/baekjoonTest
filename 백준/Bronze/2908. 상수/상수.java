

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().trim();

        StringTokenizer st = new StringTokenizer(input, " ");

        String first = st.nextToken();
        st.hasMoreTokens();
        String second = st.nextToken();

        int firstNum = Integer.parseInt(first);
        int secondNum = Integer.parseInt(second);

//        int firstResult = firstNum/100 + firstNum/10%10*10 + firstNum*100;
        int firstResult = firstNum / 100 + firstNum/10%10*10 + firstNum%10*100;
        int secondResult = secondNum / 100 + secondNum/10%10*10 + secondNum%10*100;

        if(firstResult > secondResult) {
            System.out.println(firstResult);
        } else {
            System.out.println(secondResult);
        }
    }
}
