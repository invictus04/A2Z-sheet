class Solution {
    private void generate(int nums[],List<List<Integer>> ans, List<Integer> ds, int ind) {
        ans.add(new ArrayList<>(ds));
        for(int i=ind; i<nums.length; i++){
            if(i != ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            generate(nums,ans,ds,i+1);
            ds.remove(ds.size()-1);
        }    
        

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> ans = new ArrayList<>();
       generate(nums,ans,new ArrayList<>(),0);
       return ans;
    }
}