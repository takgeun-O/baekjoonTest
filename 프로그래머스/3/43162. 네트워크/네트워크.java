class Solution {
    
    public static boolean[] visited;
    public static int[][] computer;
    
    public static void dfs(int now) {
        visited[now] = true;
        
        for(int i=0;i<computer[now].length;i++) {
            if(!visited[i] && computer[now][i]==1) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visited = new boolean[n];
        
        for(int i=0;i<n;i++) {
            
            // 해당 노드가 방문하지 않은 노드면 해당 노드를 시작으로 깊이우선탐색 진행
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}