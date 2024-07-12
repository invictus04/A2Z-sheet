class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int left = 0, right =0, zeros=0;

        while(right < nums.length) {
            if(nums[right] == 0) zeros++;
            if(zeros > k) {
                if(nums[left] == 0) zeros--;
                left++;
            }
                if(zeros <=k) {
                    int len = right-left+1;
                    max = Math.max(len,max);
                }
            right++;
        }
        return max;
    }
}