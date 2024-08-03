class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;

        int carry =0;
        int sum =0;

        StringBuilder res = new StringBuilder();

        while(i>=0 || j>=0 || carry == 1){
            sum=carry;
            if(i>=0) sum += a.charAt(i)-'0';        
            if(j>=0) sum += b.charAt(j)-'0';
            res.append((char)(sum%2+'0'));
            carry = sum/2;
            i--;
            j--;        
        }
        return res.reverse().toString();
    }
}