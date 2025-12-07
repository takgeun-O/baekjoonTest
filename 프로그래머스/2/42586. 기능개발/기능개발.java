import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int day = 0;
        
        for(int i=0;i<progresses.length;i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            day = 0;
            for(int j=0;;j++) {
                if(progress>99) {
                    day = j;
                    break;
                }
                progress += speed;
            }
            deque.addLast(day);
        }
        // System.out.println(deque);
        
        List<Integer> list = new ArrayList<>();
        while(!deque.isEmpty()) {
            int count = 1;
            int pollDay = deque.pollFirst();
            while(deque.size()>0 && pollDay >= deque.peekFirst()) {
                deque.pollFirst();
                count++;
            }
            // System.out.println(count);
            list.add(count);
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}