import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String s : completion) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        
        // for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
        //     System.out.println(entry.getKey() + " = " + entry.getValue());
        // }
        
        for(String s : participant) {
            if(hashMap.getOrDefault(s, 0) == 0) {
                return s;
            }
            hashMap.put(s, hashMap.getOrDefault(s, 0) - 1);
        }
        
        return "";
    }
}