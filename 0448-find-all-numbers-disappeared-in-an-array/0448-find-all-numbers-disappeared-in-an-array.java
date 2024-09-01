class Solution {
    private boolean isContains(int[] nums, int n){
        for(int i=0; i<nums.length; i++){
            if(n == nums[i]) return true;
        }
        return false;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        boolean[] hasNum = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            hasNum[nums[i]-1] = true;
        }
        // Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(!hasNum[i]){
                ans.add(i+1);
            }
        }
        return ans;
    }
}