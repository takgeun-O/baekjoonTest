import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int[] result = {0,};
        
        for(int i=0;i<numbers.length;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // System.out.println(set);
        
        result = set.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
        
        return result;
    }
}