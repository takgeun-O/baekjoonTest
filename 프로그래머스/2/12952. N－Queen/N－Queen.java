import java.util.*;
class Solution {
    
    private int answer;
    private boolean[] col;          // 열 사용 여부
    
    private boolean[] diag1;        // row + col (왼쪽아래 -> 오른쪽 위)
    private boolean[] diag2;        // row - col (왼쪽 위 -> 오른쪽 아래)
    
    public int solution(int n) {
        
        col = new boolean[n];
        diag1 = new boolean[n * 2 - 1];
        diag2 = new boolean[n * 2 - 1];
        
        dfs(0, n);
        return answer;
    }
    
    private void dfs(int row, int n) {
        if(row == n) {
            answer++;
            return;
        }
        
        for(int c=0;c<n;c++) {
            int d1 = row + c;
            int d2 = row - c + n - 1;
            
            if(col[c] || diag1[d1] || diag2[d2]) {
                continue;
            }
            
            col[c] = diag1[d1] = diag2[d2] = true;
            dfs(row + 1, n);
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}