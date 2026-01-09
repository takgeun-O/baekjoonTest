import java.util.*;
import java.io.*;

class Solution {
    
    public static class Node {
        int row;
        int col;
        
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    // 오른쪽 아래 왼쪽 위 (반시계 방향 순서)
    public static int[] directX = {1, 0, -1, 0};
    public static int[] directY = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        // 최단 거리 저장용 + 방문 체크용
        int[][] dist = new int[n][m];
        
        // BFS를 위한 큐
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        // 시작 노드 초기화
        dist[0][0] = 1;
        queue.addLast(new Node(0, 0));
        
        // 큐 돌리기
        while(!queue.isEmpty()) {
            
            // 큐에서 꺼내기
            Node now = queue.pollFirst();       // 현재 위치
            
            // 방향 전환하면서 예외 처리
            for(int i=0;i<4;i++) {
                int nextCol = now.col + directX[i];
                int nextRow = now.row + directY[i];
                // System.out.print("nextCol : " + nextCol + " / nextRow : " + nextRow);
                
                // 1. 다음 이동하는 칸이 맵 바깥으로 벗어나는 경우
                if(nextCol < 0 || nextRow < 0 || nextRow >= n || nextCol >= m) {
                    // System.out.println(" --> 벗어남");
                    continue;
                }
                
                // 2. 다음 이동하는 칸이 벽으로 막힌 경우
                if(maps[nextRow][nextCol] == 0) {
                    // System.out.println(" --> 막힘");
                    continue;
                }
            
                // 다음 이동하는 칸이 처음 방문하는 칸일 경우 큐에 추가하고 거리 갱신
                if(dist[nextRow][nextCol] == 0) {
                    queue.addLast(new Node(nextRow, nextCol));
                    dist[nextRow][nextCol] = dist[now.row][now.col] + 1;
                }
                // System.out.println();
            }
            // System.out.println("----------------------");
        }
        
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}