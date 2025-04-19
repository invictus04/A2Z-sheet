class Solution {
    public long upperBound(int[] nums, long value){
       int n = nums.length;
       long count = 0;
        int low =0, high = n-1;
        while(low<high){
            int sum = nums[low]+nums[high];
            if(sum>=value) {
                count += (high-low);
                high--;
            } else {
                low++;
            }
        }
            return count;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
         Arrays.sort(nums);
         return upperBound(nums,lower)-upperBound(nums,upper+1);
    }
}