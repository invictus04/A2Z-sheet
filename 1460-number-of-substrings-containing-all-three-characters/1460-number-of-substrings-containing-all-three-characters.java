class Solution {
    public int numberOfSubstrings(String s) {
        int lastSeen[] = new int[3];
        Arrays.fill(lastSeen,-1);
        int cnt=0;
        for(int i=0; i<s.length(); i++) {
            lastSeen[s.charAt(i)-'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
               int x = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                cnt += (x + 1);
            }
        }
            return cnt;
    }
}