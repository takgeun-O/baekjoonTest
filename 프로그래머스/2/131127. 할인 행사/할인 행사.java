import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        int result = 0;
        int flag = 0;
        
        for(int i=0;i<want.length;i++) {
            hashMap.put(want[i], number[i]);
        }
        
        // for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
        //     System.out.println(entry.getKey() + " = " + entry.getValue());
        // }
        
        for(int day=0;day<discount.length-9;day++) {
            flag = 0;
            for(int i=day;i<=day+9;i++) {
                
                // 그 날 할인품목이 워시리스트에 없을 경우 바로 넘어가기
                if(!hashMap.containsKey(discount[i])) {
                    break;
                }
                
                // 있으면 워시리스트 개수 1개씩 줄이기
                hashMap.put(discount[i], hashMap.get(discount[i]) - 1);
            }
            
            // for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            //     System.out.println(entry.getKey() + " = " + entry.getValue());
            // }
            
            // System.out.println();
            
            // 위처럼 한번 다 돌아서 워시리스트 개수가 모두 0보다 작으면 result++;
            for(Integer value : hashMap.values()) {
                if(value > 0) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                result++;
            }
            
            for(int i=0;i<want.length;i++) {
                hashMap.put(want[i], number[i]);
            }
        }
        
        return result;
        
    }
}