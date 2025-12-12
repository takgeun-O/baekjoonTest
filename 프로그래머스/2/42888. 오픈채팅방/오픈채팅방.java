import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();
        
        for(int i=0;i<record.length;i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            // System.out.println(st.nextToken());
            String cmd = st.nextToken();

            if(cmd.equals("Enter")) {
                String uid = st.nextToken();
                String nickName = st.nextToken();
                // 동일 uid가 들어오면 hashMap에서 해당 uid 찾아서 입장닉네임으로 모두 바꾸기
                hashMap.put(uid, nickName);
                // result에는 "들어왔습니다.", "나갔습니다." 만 저장하기
                list.add(new String[]{uid, "님이 들어왔습니다."});
            } else if(cmd.equals("Leave")) {
                String uid = st.nextToken();
                list.add(new String[]{uid, "님이 나갔습니다."});
            } else if(cmd.equals("Change")) {
                String uid = st.nextToken();
                String nickName = st.nextToken();
                hashMap.put(uid, nickName);
            }
        }
        
        String[] result = new String[list.size()];
        for(int i=0;i<list.size();i++) {
            String uid = list.get(i)[0];
            String nickName = hashMap.get(uid);
            String state = list.get(i)[1];
            // System.out.println(nickName + state);
            result[i] = nickName + state;
        }
        
        return result;
    }
}