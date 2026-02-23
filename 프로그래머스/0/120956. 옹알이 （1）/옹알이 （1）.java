import java.util.*;
import java.io.*;
class Solution {
    public int solution(String[] babbling) {
        
        String[] arrString = {"aya", "ye", "woo", "ma"};
        
        int count = 0;
        int flag = 0;
        String check = "";
        for(int i=0;i<babbling.length;i++) {
            // System.out.println("-----------------------------------");
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<babbling[i].length();j++) {
                sb.append(babbling[i].charAt(j));
                // System.out.println(sb + "*");
                
                check = sb.toString();
                for(int k=0;k<arrString.length;k++) {
                    if(check.equals(arrString[k])) {
                        // System.out.println(check + " --> 일치");
                        flag = 1;
                        sb = new StringBuilder();
                    }
                }
            }
            
            // System.out.println(sb);
            if(sb.length() == 0 && flag == 1) {
                count++;
            }
            flag = 0;
        }
        
        return count;
    }
}