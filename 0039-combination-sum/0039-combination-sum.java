class Solution {

    public void findCombi(int[] candidates,List<List<Integer>> ans, ArrayList<Integer> ds, int target, int ind){
        if(ind == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[ind] <= target){
            ds.add(candidates[ind]);
            findCombi(candidates,ans,ds,target-candidates[ind],ind);
            ds.remove(ds.size()-1);
        }

        findCombi(candidates,ans,ds,target,ind+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombi(candidates, ans, new ArrayList<>(), target,0);
        return ans;
    }
}