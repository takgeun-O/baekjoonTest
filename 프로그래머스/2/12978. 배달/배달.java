import java.util.*;

class Solution {
    
    private static class Node {
        int dest, cost;
        
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        // 인접리스트 배열 초기화
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for(int i=1;i<=N;i++) {
            adjList[i] = new ArrayList<>();
        }
        
        // road 구현 (양방향임을 주의)
        for(int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        
        pq.add(new Node(1, 0));
        dist[1] = 0;                // 시작점 -> 1번 노드까지의 현재 최단 거리
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();           // 이 노드까지의 최단 거리 확정 직전
            
            // 이미 더 좋은 경로가 있으면 스킵
            if(now.cost > dist[now.dest]) {
                continue;
            }
            
            // 인접 노드 완화
            for(Node next : adjList[now.dest]) {
                int nextDest = next.dest;
                int nextCost = now.cost + next.cost;
                
                System.out.print("nextDest : " + nextDest + ", nextCost : " + nextCost + " / ");
                
                if(dist[nextDest] > nextCost) {
                    dist[nextDest] = nextCost;
                    pq.add(new Node(nextDest, dist[nextDest]));
                }
            }
            System.out.println();
        }
        
        int answer = 0;
        // dist 배열에서 K 이하인 값의 개수 반환
        for(int i=1;i<=N;i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}