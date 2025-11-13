class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        int second = 0;
        for(int i=0;i<prices.length;i++) {
            for(int j=i+1;j<prices.length;j++) {
                if(prices[i] > prices[j]) {
                    second++;
                    break;
                } else {
                    second++;
                }
            }
            result[i] = second;
            second = 0;
        }
        
        return result;
    }
}