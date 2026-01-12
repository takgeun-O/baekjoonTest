class Solution {
    
    private static boolean[] visited;
    
    public static void dfs(int now, int[][] computers) {
        visited[now] = true;
        
        for(int i=0;i<computers[now].length;i++) {
            if(!visited[i] && computers[now][i] == 1) {
                dfs(i, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
}