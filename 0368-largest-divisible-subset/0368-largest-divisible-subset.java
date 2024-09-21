class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        int maxi = Integer.MIN_VALUE;
        int lastIndex=0;
        for(int ind = 0; ind<n; ind++){
            hash[ind] = ind;
            for(int prev =0; prev<ind; prev++){
                if(nums[ind]%nums[prev] == 0 && 1+dp[prev] > dp[ind]){
                    dp[ind] = 1+dp[prev];
                    hash[ind] = prev;
                }
            }
                if(dp[ind] > maxi){
                    maxi=dp[ind];
                    lastIndex = ind;
                }
        }
        
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}