class Solution {
    public int solution(String my_string, String is_prefix) {
        
        for(int i=0;i<is_prefix.length();i++) {
            if(is_prefix.length() > my_string.length()) {
                return 0;
            }
            if(my_string.charAt(i) != is_prefix.charAt(i)) {
                return 0;
            }
        }
        
        return 1;
    }
}