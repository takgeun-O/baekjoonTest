import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int number = 0;
        int round = 0;
        int[] result = new int[2];
        Set<String> set = new HashSet<>();
        char first;
        char last = ' ';
        int i = 0;
        
        for(String word : words) {
            number = number % n;        // 번호는 0번부터 시작하는 걸로 가정
            if(number % n == 0) {
                round++;
            }
            
            first = word.charAt(0);
            System.out.println(first + " " + last);
            
            // 끝말잇기 규칙 지키는지 확인
            if(i > 0 && first != last) {
                result[0] = number + 1;
                result[1] = round;
                break;
            }
            
            // set 에 포함된 단어가 아니면 set에 저장
            if(set.contains(word)) {
                result[0] = number + 1;
                result[1] = round;
                break;
            }
            
            set.add(word);
            number++;
            i++;
            last = word.charAt(word.length() - 1);
        }
        
        return result;
    }
}