class Solution {
        private int findSum(int[] nums, int goal) {
        int l=0, r=0, sum=0, cnt=0;
        if(goal<0) return 0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>goal && l<=r) {
                sum-=nums[l]%2;
                l++;
            }
            cnt += (r-l+1);
            r++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return findSum(nums,k)-findSum(nums,k-1);
    }
}