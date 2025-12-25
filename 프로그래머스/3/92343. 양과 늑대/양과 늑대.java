import java.util.*;
import java.io.*;

class Solution {
    
    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;
        
        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
    
    private static ArrayList<Integer>[] tree;
    
    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for(int i=0;i<tree.length;i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        
        int answer = 0;
        buildTree(info, edges);
        
        ArrayDeque<Info> queue = new ArrayDeque<>();
        // public Info(int node, int sheep, int wolf, HashSet<Integer> visited)
        queue.add(new Info(0, 1, 0, new HashSet<>()));
        
        while(!queue.isEmpty()) {
            // 큐에서 현재 상태 꺼내기
            Info now = queue.poll();
            // 최대 양의 수 업데이트
            answer = Math.max(answer, now.sheep);
            // 방문한 노드 집합에 현재 노드의 이웃 노드 추가
            // System.out.println(tree[now.node]);
            now.visited.addAll(tree[now.node]);
            
            for(int next : now.visited) {
                // now.visited -> [1, 2] 인접노드
                // 기존 해시셋의 데이터를 복사하고 현재 방문한 정점을 해시셋에서 제거
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);
                
                if(info[next] == 1) {
                    if(now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else {
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        return answer;
    }
}