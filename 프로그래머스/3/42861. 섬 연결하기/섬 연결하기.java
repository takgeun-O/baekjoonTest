import java.util.*;
import java.io.*;

class Solution {
    private static int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        // 비용을 기준으로 다리를 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        // parent 배열 초기화 (자기 자신으로 일단 초기화)
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        
        int answer = 0;     // 최소 신장 트리의 총 비용
        int edges = 0;      // 연결된 다리의 수
        
        for(int[] edge : costs) {
            // n - 1개의 다리가 연결된 경우 모든 섬이 연결된 것.
            if(edges == n - 1) {
                break;
            }
            
            // 현재 다리가 연결하는 두 섬이 이미 연결되어 있는지 체크
            // 연결되어 있지 않으면 두 섬을 하나의 집합으로 연결
            if(find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                
                answer = answer + edge[2];      // 비용 누적
                edges = edges + 1;              // 사용된 다리 개수 추가
            }
        }
        
        return answer;
    }
    
    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}