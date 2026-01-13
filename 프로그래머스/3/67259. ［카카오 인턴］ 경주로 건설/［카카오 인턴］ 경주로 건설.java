import java.util.*;

class Solution {
    
    // 오른쪽, 아래, 왼쪽, 위
    private static int[] dr = {0, 1, 0, -1};
    private static int[] dc = {1, 0, -1, 0};
    
    private static class Node {
        int r, c, dir, cost;
        
        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dist = new int[n][n][4];
        for(int r=0;r<n;r++) {
            for(int c=0;c<n;c++) {
                Arrays.fill(dist[r][c], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, -1, 0));
        
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.r == n - 1 && now.c == n - 1) {
                return now.cost;
            }
            
            for(int i=0;i<4;i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }
                if(board[nr][nc] == 1) {
                    continue;
                }
                
                int add;
                if(now.dir == -1) {
                    add = 100;
                } else if(now.dir == i) {
                    add = 100;
                } else {
                    add = 600;
                }
                
                int newCost = now.cost + add;
                
                if(dist[nr][nc][i] > newCost) {
                    dist[nr][nc][i] = newCost;
                    pq.add(new Node(nr, nc, i, newCost));
                }
            }
        }
        
        return -1;
    }
}