import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        ArrayDeque<String> cards1Deque = new ArrayDeque<>();
        ArrayDeque<String> cards2Deque = new ArrayDeque<>();
        ArrayDeque<String> goalDeque = new ArrayDeque<>();
        int flag = 0;
        String result = "";
        
        for(int i=0;i<cards1.length;i++) {
            cards1Deque.addLast(cards1[i]);
        }
        
        for(int i=0;i<cards2.length;i++) {
            cards2Deque.addLast(cards2[i]);
        }
        
        for(int i=0;i<goal.length;i++) {
            goalDeque.addLast(goal[i]);
        }
        
        while(!goalDeque.isEmpty()) {
            String pollGoal = goalDeque.pollFirst();
            flag = 0;
            
            if(!cards1Deque.isEmpty() && pollGoal.equals(cards1Deque.peekFirst())) {
                // 카드뭉치가 비어있지 않으면서 픽한 문자열이 일치할 경우
                cards1Deque.pollFirst();
                flag = 1;
            } else if (!cards2Deque.isEmpty() && pollGoal.equals(cards2Deque.peekFirst())) {
                cards2Deque.pollFirst();
                flag = 1;
            }
            
            if(flag == 0) {
                result = "No";
                break;
            }
        }
        
        if(flag == 1) {
            result = "Yes";
        }
        
        return result;
    }
}