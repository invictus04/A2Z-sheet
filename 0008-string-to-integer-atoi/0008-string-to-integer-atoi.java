class Solution {
    public int myAtoi(String s) {
        if(s == null) return 0;
        long ans =0; 
        int chk = +1;
        int cnt =0;
        s=s.trim();
        if(s.length()==0) return 0;
        if(s.charAt(0) == '-') chk = -1;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1:0;
        while(i<s.length()) {
            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) break; 
            ans = ans*10 + s.charAt(i)-'0';
            if(chk == -1 && -1*ans<min) return min;
            if(chk == 1 && ans>max) return max;
            i++;
        }
        ans = ans*chk;
        return (int)ans;
    }
}