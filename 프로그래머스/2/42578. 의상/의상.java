import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++) {
            map.computeIfAbsent(clothes[i][1], k -> new ArrayList<>())
                .add(clothes[i][0]);
        }
        
        // System.out.println(map);
        
        int x = 1;
        int row = -1;
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            
            x = x * (size + 1);
        }
        // System.out.println(x);
        
        return x - 1;
        
    }
}