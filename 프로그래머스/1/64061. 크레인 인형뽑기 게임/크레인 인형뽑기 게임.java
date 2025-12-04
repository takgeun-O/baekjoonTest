import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for(int i=0;i<moves.length;i++) {
            int row = -1;
            int col = moves[i] - 1;
            for(int j=0;j<board.length;j++) {
                if(board[j][col] != 0) {
                    row = j;
                    break;
                }
            }
            if(row == -1) {
                // 해당 컬럼에서 0이 아닌 숫자 못 찾으면 다음 무빙으로 넘어가기
                continue;
            }
            
            int pick = board[row][col];
            board[row][col] = 0;
            // System.out.println(pick);
            
            // 인형뽑기가 확정되면 바구니에 담기
            if(stack.size() == 0) {
                // 스택사이즈가 0이면 그냥 푸시
                stack.push(pick);
            } else {
                // 뽑은 인형과 스택의 peek과 같으면
                // stack.pop() 처리 후 count++
                // 같지 않으면 그대로 푸시
                if(pick == stack.peek()) {
                    stack.pop();
                    count++;
                } else {
                    stack.push(pick);
                }
            }
        }
        return count * 2;
    }
}