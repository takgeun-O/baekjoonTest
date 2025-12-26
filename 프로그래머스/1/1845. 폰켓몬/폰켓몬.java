import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        
        // 중복 제거
        int[] distinct = Arrays.stream(nums)
            .distinct()
            .toArray();
        
        int count = nums.length / 2;        // N / 2 마리 고르기
        int distinctLength = distinct.length;
        
        // distinct의 길이가 count보다 작으면 해당 길이가 답
        // distinct의 길이가 count보다 크면 count가 답
        
        System.out.println("count = " + count + " distinctLength = " + distinctLength);
        int result = 0;
        if(distinctLength < count) {
            result = distinctLength;
        } else {
            result = count;
        }
        return result;
    }
}