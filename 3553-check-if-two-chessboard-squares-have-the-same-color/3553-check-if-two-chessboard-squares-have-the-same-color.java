class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int ch1 = coordinate1.charAt(0)-'a' + 1;
        int ch2 = coordinate2.charAt(0) - 'a'+ 1;
        int num1 = coordinate1.charAt(1)-'0';
        int num2 = coordinate2.charAt(1)- '0';
       if((ch1+num1)%2 == 0 && (ch2+num2)%2 == 0) return true;
       if((ch1+num1)%2 != 0 && (ch2+num2)%2 != 0) return true;
       return false;
    }
}