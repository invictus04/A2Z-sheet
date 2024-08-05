class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> mpp = new HashMap<>();
        int cnt =0;
        for(String ch: arr){
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }

        for(String ans: arr){
            if(mpp.get(ans) == 1){
                cnt++;
                if(cnt==k) return ans;
            }
        }
        return "";
    }
}