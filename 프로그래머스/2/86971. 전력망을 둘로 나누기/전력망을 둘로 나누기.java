import java.util.*;
class Solution {
    
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        
        adjList = new ArrayList[n + 1];
        for(int i=1;i<=n;i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : wires) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        int answer = Integer.MAX_VALUE;
        for(int[] cut : wires) {
            visited = new boolean[n + 1];
            
            int count = dfs(cut[0], cut[0], cut[1]);
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    private int dfs(int now, int cutA, int cutB) {
        visited[now] = true;
        int sum = 1;
        
        // 인접리스트
        for(int next : adjList[now]) {
            
            if((now == cutA && next == cutB) || (now == cutB && next == cutA)) {
                continue;
            }
            
            if(!visited[next]) {
                sum = sum + dfs(next, cutA, cutB);
            }
        }
        return sum;
    }
}