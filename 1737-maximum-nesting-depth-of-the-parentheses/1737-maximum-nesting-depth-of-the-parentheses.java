class Solution {
    public int maxDepth(String s) {
        int cnt=0;
        int maxi = -1;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                cnt++;
                maxi = Math.max(cnt,maxi);
            } else if(s.charAt(i) == ')'){
                cnt--;
            }
        }
        if(maxi == -1) return 0;
        return maxi;
    }
}