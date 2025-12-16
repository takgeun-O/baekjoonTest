import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for(String s : report) {
            String[] split = s.split(" ");
            String reporterId = split[0];
            String reportedId = split[1];
            
            if(!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<String>());
            }
            
            reportedUser.get(reportedId).add(reporterId);
            
        }
        
        // for(Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }
        
        HashMap<String, Integer> countMap = new HashMap<>();
        
        for(Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if(entry.getValue().size() >= k) {
                for(String uid : entry.getValue()) {
                    countMap.put(uid, countMap.getOrDefault(uid, 0) + 1);
                }
            }
        }
        
        // for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }
        
        for(int i=0;i<id_list.length;i++) {
            answer[i] = countMap.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}