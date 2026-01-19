import java.util.*;
class Solution {
    
    private static boolean[] visited;
    private static int answer;
    private static int[][] Dungeons;
    
    public int solution(int k, int[][] dungeons) {
        
        answer = 0;
        Dungeons = dungeons;
        
        visited = new boolean[dungeons.length];
        
        backtrack(k, 0);
        
        return answer;
    }
    
    private static void backtrack(int k, int count) {
        
        for(int i=0;i<Dungeons.length;i++) {
            
            if(!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - Dungeons[i][1], count + 1);
                answer = Math.max(answer, count + 1);
                visited[i] = false;
            }
        }
    }
}