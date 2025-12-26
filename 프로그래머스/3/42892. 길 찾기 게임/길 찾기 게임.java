import java.util.*;
import java.io.*;

class Solution {
    
    private static class Node {
        int idx;
        int x, y;
        Node left, right;
        
        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        
        int n = nodeinfo.length;
        List<Node> nodes = new ArrayList<>(n);
        
        // 노드에 번호 붙이기
        // [[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]
        for(int i=0;i<n;i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            nodes.add(new Node(x, y, i+1));
        }
        
        // y좌표 내림차순
        // y좌표 같으면 x좌표 오름차순
        nodes.sort((a, b) -> {
            if(a.y != b.y) {
                return b.y - a.y;
            }
            return a.x - b.x;
        });
        
        // 트리 구조 완성하기
        Node root = nodes.get(0);
        for(int i=1;i<n;i++) {
            insert(root, nodes.get(i));
        }
        

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        preorder(root, pre);
        postorder(root, post);
        
        int[][] result = new int[2][n];
        for(int i=0;i<n;i++) {
            result[0][i] = pre.get(i);
            result[1][i] = post.get(i);
        }
        
        return result;
    }
    
    private void insert(Node parent, Node child) {
        // 왼쪽 자식 결정
        if(child.x < parent.x) {
            // 부모의 자식을 결정할 때 해당 부분에 자식이 없어야 함.
            if(parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    private void preorder(Node node, List<Integer> out) {
        if(node == null) return;
        out.add(node.idx);
        preorder(node.left, out);
        preorder(node.right, out);
    }
    
    private void postorder(Node node, List<Integer> out) {
        if(node == null) return;
        postorder(node.left, out);
        postorder(node.right, out);
        out.add(node.idx);
    }
}