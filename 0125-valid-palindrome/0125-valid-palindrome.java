class Solution {
    public boolean isPalindrome(String s) {
      if(s.length() == 1) return true;
      s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
      StringBuilder res = new StringBuilder(s);
      String rev = res.reverse().toString();
      if(s.equals(rev) == true) return true;
      return false;

    }
}