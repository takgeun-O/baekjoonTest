import java.util.*;

class Solution {
    
    private static char[][] grid;
    // 오른쪽, 아래, 왼쪽, 위
    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};
    private static int n;
    private static int m;
    
    private static class Node {
        int r, c;
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private static int bfs(Node from, Node to) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        
        dist[from.r][from.c] = 1;
        queue.addLast(from);
        
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            for(int i=0;i<4;i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                // System.out.println(nr + " " + nc);
                
                // 맵 바깥으로 벗어날 때
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                // 벽으로 막혔을 때
                if(grid[nr][nc] == 'X') {
                    continue;
                }
                
                // 방문 안했을 때만 큐에 넣고 갱신
                if(dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                    queue.addLast(new Node(nr, nc));
                }
                
                // 목표 지점 도달 시 곧바로 반환
                if(nr == to.r && nc == to.c) {
                    return dist[nr][nc] - 1;
                }
            }
        }
        return -1;
    }
    
    
    public int solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        grid = new char[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                grid[i][j] = maps[i].charAt(j);
            }
        }
        
        Node start = null;
        Node lever = null;
        Node end = null;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 'S') {
                    start = new Node(i, j);
                } else if(grid[i][j] == 'L') {
                    lever = new Node(i, j);
                } else if(grid[i][j] == 'E') {
                    end = new Node(i, j);
                }
            }
        }
        
        // System.out.println("start -> (" + start.r + ", " + start.c + ")");
        // System.out.println("lever -> (" + lever.r + ", " + lever.c + ")");
        // System.out.println("end -> (" + end.r + ", " + end.c + ")");
        
        int startToLever = bfs(start, lever);
        int leverToEnd = bfs(lever, end);
        
        if(startToLever == -1 || leverToEnd == -1) {
            return -1;
        }
        
        return startToLever + leverToEnd;
    }
}