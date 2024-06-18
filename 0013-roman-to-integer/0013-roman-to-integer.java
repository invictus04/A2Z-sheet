class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        mpp.put('I',1);
        mpp.put('V',5);
        mpp.put('X',10);
        mpp.put('L',50);
        mpp.put('C',100);
        mpp.put('D',500);
        mpp.put('M',1000);

        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            if(i < s.length() - 1 && mpp.get(s.charAt(i)) < mpp.get(s.charAt(i + 1))){
                ans-=mpp.get(s.charAt(i));
            } else {
                ans+=mpp.get(s.charAt(i));
            }
        }
        return ans;
        
    }
}