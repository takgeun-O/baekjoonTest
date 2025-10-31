import java.io.*;
import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int[][] result = new int[arr1.length][arr2[0].length];
        // 결과는 arr1의 행수, arr2의 열수 모양을 따라감.
        
        int sum = 0;
        for(int i=0;i<arr1.length;i++) {
            for(int j=0;j<arr2[0].length;j++) {
                for(int k=0;k<arr1[i].length;k++) {
                    sum = sum + arr1[i][k] * arr2[k][j];
                }
                result[i][j] = sum;
                sum = 0;
            }
        }
        
        return result;
        
    }
}