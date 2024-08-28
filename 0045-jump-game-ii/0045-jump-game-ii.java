class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left=0, right=0, jumps=0;
        while(right<n-1){
            int far = 0;
            for(int i=left; i<=
            right; i++){
                far = Math.max(far,i+nums[i]);
            }
            left++;
            right = far;
            jumps++;
        }
    return jumps;

    }
}