import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        
        int deeps = n / w + 1;      // 최대 층수
        int[][] boxes = new int[deeps][w];
        int count = 1;
        
        for(int i=0;i<deeps;i++) {
            if(i%2==0) {
                // 홀수층이면 왼쪽에서 오른쪽으로 증가
                for(int j=0;j<w;j++) {
                    if(count > n) {
                        break;
                    }
                    boxes[deeps-i-1][j] = count;
                    count++;
                }
            } else {
                // 짝수층이면 오른쪽에서 왼쪽으로 증가
                for(int j=0;j<w;j++) {
                    if(count > n) {
                        break;
                    }
                    boxes[deeps-i-1][w-1-j] = count;
                    count++;
                }
            }
        }
        
        // for(int i=0;i<deeps;i++) {
        //     for(int j=0;j<w;j++) {
        //         System.out.print(boxes[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        // 박스 배열에서 해당 숫자를 찾고
        // 맨 위에서 목표 박스까지 내려올 때 0이 아닌 숫자의 박스 개수 반환하면 끝.
        int answer = 0;
        for(int i=0;i<deeps;i++) {
            for(int j=0;j<w;j++) {
                if(num == boxes[i][j]) {
                    for(int k=0;k<=i;k++) {
                        if(boxes[k][j] != 0) {
                            answer++;
                        }
                    }
                    return answer;
                }
            }
        }
        
        return 0;
    }
}