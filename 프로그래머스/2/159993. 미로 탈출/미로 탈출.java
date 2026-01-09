import java.util.*;
class Solution {
    
    // 오른쪽, 아래, 왼쪽, 위
    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};
    private static char[][] grid;
    private static int n, m;
    
    private static class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private static int bfs(Node start, Node end) {
        int[][] dist = new int[n][m];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        dist[start.r][start.c] = 1;
        queue.addLast(start);
        
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            for(int i=0;i<4;i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                // 맵 밖으로 벗어나는 예외 처리
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                // 해당 칸이 벽일 경우 예외 처리
                if(grid[nr][nc] == 'X') {
                    continue;
                }
                // 이미 방문했을 경우 예외 처리
                if(dist[nr][nc] > 0) {
                    continue;
                }
                
                // 우선 걸린시간 카운트하면서 방문 처리해놓고
                dist[nr][nc] = dist[now.r][now.c] + 1;
                // 만약 해당 dist 위치의 값이 end 위치와 동일하면 곧바로 걸린 시간 리턴
                if(nr == end.r && nc == end.c) {
                    return dist[nr][nc] - 1;
                }
                queue.addLast(new Node(nr, nc));
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        // 주어진 맵을 grid 로 구현
        grid = new char[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                grid[i][j] = maps[i].charAt(j);
            }
        }
        
        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<m;j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        // 시작지점, 레버지점, 출구지점 찾기
        Node start = null;
        Node lever = null;
        Node end = null;
        for(int r=0;r<n;r++) {
            for(int c=0;c<m;c++) {
                if(grid[r][c]=='S') {
                    start = new Node(r, c);
                } else if(grid[r][c]=='L') {
                    lever = new Node(r, c);
                } else if(grid[r][c]=='E') {
                    end = new Node(r, c);
                }
            }
        }
        
        // System.out.println(start.r + " " + start.c);
        // System.out.println(lever.r + " " + lever.c);
        // System.out.println(end.r + " " + end.c);
        
        // 시작지점부터 레버지점까지의 최단거리를 bfs로 구하기
        int startToLever = bfs(start, lever);
        // 레버지점부터 출구지점까지 최단거리를 bfs로 구하기
        int leverToEnd = bfs(lever, end);
        
        if(startToLever == -1) {
            return -1;
        }
        if(leverToEnd == -1) {
            return -1;
        }
        
        return startToLever + leverToEnd;
    }
}