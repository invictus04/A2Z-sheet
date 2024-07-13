class Solution {

    private int findSum(int[] nums, int goal) {
        int l=0, r=0, sum=0, cnt=0;
        if(goal<0) return 0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal && l<=r) {
                sum=sum-nums[l];
                l++;
            }
            cnt += (r-l+1);
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSum(nums,goal)-findSum(nums,goal-1);
    }
}