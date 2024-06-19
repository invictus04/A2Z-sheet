class Solution {
    public int myAtoi(String s) {
        s = s.trim(); 
        if (s.isEmpty()) return 0; 
        return atoiRecursive(s, 0, 1, 0); 
    }

    public int atoiRecursive(String s, int idx, int sign, long res) {
        if (idx == s.length()) return (int) (sign * res); 
        
        char c = s.charAt(idx); 
        
        if (Character.isDigit(c)) {
            res = (res * 10) + (c - '0');
            if (res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return atoiRecursive(s, idx + 1, sign, res);
        } else if (idx == 0 && (c == '+' || c == '-')) {
            if (c == '-') sign = -1;
            return atoiRecursive(s, idx + 1, sign, res);
        }
        return (int) (sign * res);
    }
}