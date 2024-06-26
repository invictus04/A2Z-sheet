class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int subsets = 1<<n;


        for(int i=0; i<subsets; i++) {
            List<Integer> res = new ArrayList<>();
            for(int j=0; j<n; j++){
                if((i &(1<<j)) != 0) res.add(nums[j]);
            }
            ans.add(new ArrayList<>(res));
        }
        return ans;
     }
}