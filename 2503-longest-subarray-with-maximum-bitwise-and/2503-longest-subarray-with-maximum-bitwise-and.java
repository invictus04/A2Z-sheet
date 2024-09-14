class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal=0,ans=0, count=0;
        for(int num: nums){
            if(maxVal<num){
                maxVal = num;
                ans = count =0;
            }

            if(maxVal == num){
                count++;
            } else {
                count=0;
            }

            ans = Math.max(ans,count);
        }
        return ans;
    }
}