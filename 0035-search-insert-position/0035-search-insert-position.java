class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        if(target>nums[right-1]) return right;
        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}