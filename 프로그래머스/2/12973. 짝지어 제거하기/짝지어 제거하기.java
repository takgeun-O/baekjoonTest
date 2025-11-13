import java.util.*;
import java.io.*;

class Solution
{
    public int solution(String s)
    {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        char top = '0';
        
        for(int i=0;i<charArray.length;i++) {
            if(charArray[i] == top) {
                stack.pop();
                if(stack.isEmpty()) {
                    top = '0';
                } else {
                    top = stack.peek();
                }
            } else {
                stack.add(charArray[i]);
                top = stack.peek();
            }
            // System.out.println(stack);
        }
        
        if(stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
        
        
    }
}