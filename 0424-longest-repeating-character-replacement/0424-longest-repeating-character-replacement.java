class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r=0,maxf=0;
        int max = Integer.MIN_VALUE;
        int hash[] = new int[26];
        while(r<s.length()){
            hash[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf,hash[s.charAt(r)-'A']);
            if((r-l+1)-maxf>k) {
                hash[s.charAt(l)-'A']--;
                maxf=0;
                l++;
            }
            if((r-l+1)-maxf<=k) {
                max=Math.max(max,r-l+1);
            }
            r++;
        }
        return max;
    }
}