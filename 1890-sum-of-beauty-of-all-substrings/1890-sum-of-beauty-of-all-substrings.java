class Solution {
    public int beautySum(String s) {
        int ans =0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            HashMap<Character, Integer> mpp = new HashMap<>();
            for(int j=i; j<n; j++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                mpp.put(s.charAt(j),mpp.getOrDefault(s.charAt(j),0)+1);
                if(mpp.size() == 1) continue;
                else {
                    for(Map.Entry<Character,Integer> entry: mpp.entrySet()){
                        max=Math.max(max,entry.getValue());
                        min=Math.min(min,entry.getValue());
                    }
                    ans+=(max-min);
                }
            }
        }
        return ans;
    }
}