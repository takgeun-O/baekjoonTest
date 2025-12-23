import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        // enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
        // referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
        // seller = ["young", "john", "tod", "emily", "mary"]
        // amount = [12, 4, 2, 5, 10]
        // result = [360, 958, 108, 0, 450, 18, 180, 1080]
        
        
        // 해시맵으로 판매자의 추천자 찾기
        HashMap<String, String> recommender = new HashMap<>();
        
        for(int i=0;i<enroll.length;i++) {
            recommender.put(enroll[i], referral[i]);
        }
        
        // System.out.println(recommender);
        
        // 현재 판매자 계산 후 현재 판매자의 추천자로 순회하면서 별도의 해시맵에 판매자/금액 저장하기
        HashMap<String, Integer> result = new HashMap<>();
        for(int i=0;i<seller.length;i++) {
            String sellerName = seller[i];
            int money = amount[i] * 100;
            
            while(money > 0 && !sellerName.equals("-")) {
                result.put(sellerName, result.getOrDefault(sellerName, 0) + money - (money / 10));  // 1200 - (1200/10)
                sellerName = recommender.get(sellerName);
                money = money / 10;
            }
        }
        
        // int[] answer = {0};
        // // System.out.println(result);
        // System.out.println(result.get(enroll[0]));
        
        // enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
        // result = [360, 958, 108, 0, 450, 18, 180, 1080]
        int[] answer = new int[enroll.length];
        for(int i=0;i<answer.length;i++) {
            // enroll에는 있는데 seller에는 없는 경우 해시맵상에서는 null이니까 이것도 처리해주기
            if(result.get(enroll[i])==null) {
                answer[i] = 0;
            } else {
                answer[i] = result.get(enroll[i]);
            }
        }
        
        return answer;
    }
}