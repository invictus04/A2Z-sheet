class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length;i++){
            if((nums[i-1] ^ nums[i]) == 0) return true;
        }
        return false;
    }
}