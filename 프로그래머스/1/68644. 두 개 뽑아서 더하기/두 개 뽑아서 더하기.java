import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] clone = numbers.clone();
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<clone.length;i++) {
            for(int j=i+1;j<clone.length;j++) {
                int sum = clone[i] + clone[j];
                set.add(sum);
            }
        }
        
        int i = 0;
        int[] answer = new int[set.size()];
        for(Integer num : set) {
            answer[i++] = num;
        }
        
        return Arrays.stream(answer)
            .sorted()
            .toArray();
    }
}