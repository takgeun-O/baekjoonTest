import java.util.*;

class Solution {
    
    private static class Node {
        int row, col;
        
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    // 오른쪽, 아래, 왼쪽, 위
    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        // 최단 거리 저장 + 방문 체크용
        int[][] dist = new int[n][m];
        
        // BFS를 위한 큐 준비
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        // 초기화
        dist[0][0] = 1;
        queue.addLast(new Node(0, 0));
        
        // 큐 돌리기
        while(!queue.isEmpty()) {
            
            Node now = queue.poll();
            
            for(int i=0;i<4;i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                
                // 해당 좌표가 맵 바깥으로 벗어날 경우
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                
                // 해당 좌표가 벽으로 막힌 경우
                if(maps[nr][nc] == 0) {
                    continue;
                }
                
                // 해당 좌표가 처음 방문하는 칸이면 큐에 추가하고 거리 갱신
                if(dist[nr][nc] == 0) {
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.row][now.col] + 1;
                }
            }
        }
        
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}