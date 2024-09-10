class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int cnt =0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                maxi = Math.max(maxi,cnt);
                cnt=0;
            } else {
                cnt++;
            }
        }
        maxi = Math.max(maxi,cnt);
       
        return maxi;
    }
}