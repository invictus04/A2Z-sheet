class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        // if(len == 0) return s;

        int left = 0;
        for(int i = len-1; i>=0; i--){
            if(s.charAt(i) == s.charAt(left)){
                left++;
            }
        }

        if(left == len) return s;

        String nonpalid = s.substring(left);
        StringBuilder rev = new StringBuilder(nonpalid).reverse();

        return rev.append(shortestPalindrome(s.substring(0,left))).append(nonpalid).toString(); 
    }
}