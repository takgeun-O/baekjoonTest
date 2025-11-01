import java.io.*;
import java.util.*;
class Solution {
    public int solution(String dirs) {
        int startX = 5;
        int startY = 5;
        int answer = 0;
        Set<String> edges = new HashSet<>();
        
        for(int i=0;i<dirs.length();i++) {
            char cmd = dirs.charAt(i);
            
            int arriveX = startX;
            int arriveY = startY;
            
            if(cmd == 'U') {
                arriveY = startY + 1;
            } else if(cmd == 'D') {
                arriveY = startY - 1;
            } else if(cmd == 'R') {
                arriveX = startX + 1;
            } else if(cmd == 'L') {
                arriveX = startX - 1;
            }
            
            if(arriveX < 0 || arriveX > 10 || arriveY < 0 || arriveY > 10) {
                continue;
            }
            
            String start = "(" + startX + ", " + startY + ")";
            String end = "(" + arriveX + ", " + arriveY + ")";
            
            String key;
            // 사전순으로 작은 좌표의 점을 앞에 두기 ( (0,1) -> (1,1) 가는거랑 (1,1) -> (0,1) 가는 것을 동일시하기 위해)
            if(start.compareTo(end) <= 0) {
                key = start + "-" + end;
            } else {
                key = end + "-" + start;
            }
            
            if(edges.add(key)) {        // 새로운 간선이면 카운트
                answer++;
            }
            
            startX = arriveX;
            startY = arriveY;
        }
        return answer;
    }
}