

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        for(int i=0;i<arr.length;i++) {
            arr[i] = -1;
        }

        String input = br.readLine();

        for(int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if(arr[ch-'a']==-1) {
                arr[ch-'a'] = i;
            }
        }

        for(int val : arr) {
            System.out.print(val + " ");
        }

    }
}
