import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] clone = answers.clone();
        
        // answer의 길이를 구해서 각 수포자가 찍는 답안의 길이 결정하기
        // answer와 각 수포자가 찍은 답의 일치여부 체크해서 별도의 배열에 맞은 갯수 넣어놓기
        // 별도의 배열에서 max인 수포자 구하기 (max가 동점인 수포자가 여러 명이면 수포자번호를 오름차순 처리)
        
        int length = clone.length;
        
        int[] person1 = {1,2,3,4,5};            // % 연산으로 순회하기
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] answerCount = new int[3];
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i=0;i<length;i++) {
            if(clone[i]==person1[i%person1.length]) {
                answerCount[0] = ++count1;
            }
            if(clone[i]==person2[i%person2.length]) {
                answerCount[1] = ++count2;
            }
            if(clone[i]==person3[i%person3.length]) {
                answerCount[2] = ++count3;
            }
        }
        // [1,3,2,4,2]
        // answerCount = [2,2,2]
        
        int maxScore = Arrays.stream(answerCount).max().getAsInt();     // 2
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<answerCount.length;i++) {
            if(maxScore == answerCount[i]) {
                result.add(i+1);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}