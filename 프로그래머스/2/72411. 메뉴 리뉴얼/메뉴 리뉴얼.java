import java.util.*;

class Solution {

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int targetLen : course) {

            // targetLen 길이 조합들의 등장 횟수(=몇 명 주문에서 나왔는지) 카운트
            Map<String, Integer> countMap = new HashMap<>();

            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr); // ★ 중요: 조합을 항상 같은 형태(정렬된 문자열)로 만들기
                comb(arr, 0, targetLen, new StringBuilder(), countMap);
            }

            // 해당 길이에서 최댓값 찾기
            int maxCount = 0;
            for (int v : countMap.values()) {
                maxCount = Math.max(maxCount, v);
            }

            // 최소 2명 이상 조건
            if (maxCount < 2) continue;

            // 최댓값인 조합들만 추가
            for (Map.Entry<String, Integer> e : countMap.entrySet()) {
                if (e.getValue() == maxCount) {
                    answer.add(e.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    // orderChars에서 targetLen개를 뽑는 조합 생성
    private void comb(char[] orderChars, int start, int targetLen,
                      StringBuilder sb, Map<String, Integer> countMap) {

        if (sb.length() == targetLen) {
            String combo = sb.toString();
            countMap.put(combo, countMap.getOrDefault(combo, 0) + 1);
            return;
        }

        for (int i = start; i < orderChars.length; i++) {
            sb.append(orderChars[i]);
            comb(orderChars, i + 1, targetLen, sb, countMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
