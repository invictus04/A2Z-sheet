class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        create(nums,0,ans,subset);
        return ans;
    }

    public void create(int[] nums, int n, List<List<Integer>> ans, List<Integer> subset){
        if(n == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[n]);
        create(nums,n+1,ans, subset);
        subset.remove(subset.size()-1);
        create(nums,n+1,ans,subset);
    }
}