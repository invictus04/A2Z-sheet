class Solution {
     public void findCombi(int[] candidates,List<List<Integer>> ans, ArrayList<Integer> ds, int target, int ind){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<candidates.length; i++){
            if(i>ind && candidates[i] == candidates[i-1]) continue;
            if(candidates[i]>target) break;

            ds.add(candidates[i]);
            findCombi(candidates,ans,ds,target-candidates[i], i+1);
            ds.remove(ds.size()-1);
        }
     }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombi(candidates, ans, new ArrayList<>(), target,0);
        return ans;
    }
}