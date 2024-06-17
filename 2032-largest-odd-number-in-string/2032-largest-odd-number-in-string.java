class Solution {
    public String largestOddNumber(String num) {
        int i = num.length()-1;
        for(; i>=0; i--) {
            if(num.charAt(i)%2==1) break;
        }
        return num.substring(0,i+1);
    }
}