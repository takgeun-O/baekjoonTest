import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {
        
        int rows = maps.length;
        int cols = maps[0].length;
        
        // 시작이나 도착이 막혀있으면 바로 -1
        if(maps[0][0] == 0 || maps[rows-1][cols-1] == 0) {
            return -1;
        }
        
        int[][] dist = new int[rows][cols];     // visited + 거리 저장
        dist[0][0] = 1;
        
        // 오른쪽, 아래, 위, 왼쪽 순서로 이동
        // {dx, dy}
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int dir = 0;dir < 4;dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                // 경계 체크
                if(nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    continue;
                }
                // 벽이면 패스
                if(maps[nx][ny] == 0) {
                    continue;
                }
                // 이미 방문했으면 패스
                if(dist[nx][ny] != 0) {
                    continue;
                }
                
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        
        return dist[rows-1][cols-1] == 0 ? -1 : dist[rows-1][cols-1];
    }
}