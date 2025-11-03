import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if((n%2) == 1) {
            return 0;
        }
        
        String ss = s + s;      // 회전 대신 슬라이딩 윈도우
        int answer = 0;
        
        for(int start = 0;start < n;start++) {
            if(isValid(ss, start, n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isValid(String ss, int start, int len) {
        Deque<Character> st = new ArrayDeque<>();
        
        for(int i=start;i<start+len;i++) {
            // 한 칸씩 슬라이딩한 문자열로 조사
            char c = ss.charAt(i);
            if(isOpen(c)) {
                st.push(c);
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if(!match(top, c)) {
                    return false;
                }
            }
        }
        return st.isEmpty();            // 비어있으면 올바른 괄호 문자열
    }
    
    private boolean isOpen(char c) {
        return c == '[' || c =='{' || c == '(';
    }
    
    private boolean match(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '{' && close == '}')
            || (open == '[' && close == ']');
    }
}