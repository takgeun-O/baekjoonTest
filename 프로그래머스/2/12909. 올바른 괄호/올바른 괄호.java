import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
    
        Character prev = null;
        for(int i=0;i<s.length();i++) {
            stack.push(s.charAt(i));
            
            if(stack.size()==1) {
                if(stack.peek()==')') {
                    return false;
                }
                prev = stack.peek();
                continue;
            }
            
            if(stack.peek()!=prev) {
                stack.pop();
                stack.pop();
            } else {
                prev = stack.peek();
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}