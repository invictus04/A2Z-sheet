class Solution {
    private void combi(int k, int n, int ind, List<List<Integer>> ans, List<Integer> ds){
      if(n==0 && k==0){
        ans.add(ds);
        return;  
      }
      if(ind>9) return;
      if(n<0 || k<0) return;
      List<Integer> temp = new ArrayList<>(ds);
     temp.add(ind);
      combi(k-1,n-ind, ind+1,ans,temp);
      combi(k,n, ind+1,ans,ds);
    }
    
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combi(k,n,1,ans, new ArrayList<>());
        return ans;
    }
}