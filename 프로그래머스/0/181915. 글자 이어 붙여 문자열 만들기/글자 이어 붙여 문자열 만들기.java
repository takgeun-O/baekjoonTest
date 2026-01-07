class Solution {
    public String solution(String my_string, int[] index_list) {
        
        String result = "";
        
        for(int i=0;i<index_list.length;i++) {
            result = result + my_string.charAt(index_list[i]);
        }
        
        return result;
    }
}