import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        double[] failRate = new double[N+1];
        Integer[] result = new Integer[N];
        
        for(int i=0;i<result.length;i++) {
            result[i] = i + 1;          // 기존 인덱스값 기록해두기
        }
        
        int remain = stages.length;     // 해당 스테이지를 도전하는 사람의 수 (성공한 사람은 빠질 것)
        
        for(int i=1;i<=N+1;i++) {      // N개의 스테이지 순회 (N+1은 마지막 스테이지까지 모두 클리어한 사람)
            // 각 스테이지별 실패율 구해서 별도의 배열에 담아보자.
            
            int fail = 0;                // 해당 스테이지를 성공하지 못한 사람수 (매 스테이지마다 0으로 초기화)
            // 스테이지 i번일 때 아직 클리어하지 못한 사람 수 구하기
            for(int j=0;j<stages.length;j++) {
                if(i==stages[j]) {
                    fail++;
                }
            }
            failRate[i-1] = (remain == 0) ? 0.0 : (double)fail / remain;                  // 확인 완료
            remain = remain - fail;
        }
        
        // failRate 마지막 인덱스값은 버려야함. (모두 클리어한 사람 수니깐)
        
        double[] newFailRate = new double[N];
        for(int i=0;i<N;i++) {
            newFailRate[i] = failRate[i];
        }
        
        // 기본적으로 내림차순하되, 동점일 땐 오름차순
        // compare(int x, int y) -> return (x < y) ? -1 : ((x==y) ? 0 : 1);
        Arrays.sort(result, (a, b) -> {     // result의 두 원소 a, b 비교할 때마다 실행하고 newFailRate값을 기준으로 result의 값 변경
            int cmp = Double.compare(newFailRate[b-1], newFailRate[a-1]);       // "앞에 값이 더 크면 양수, 뒤에 값이 더 크면 음수, 같으면 음수"가 기본인데 거꾸로 하면 내림차순처럼 작동하는 것
            if(cmp != 0) {
                return cmp;
            }
            return Integer.compare(a, b);       // 같으면 오름차순
        });
        
        
        
        return Arrays.stream(result)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}