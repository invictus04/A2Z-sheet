class Solution {
    public int getsum(int arr[], int n, int sum, int ind, int s, int dp[][]){
        if(ind == n){
            if(s==sum){
               return 1;
            } 
            return 0;
        }
        if(dp[ind][s] != -1) return dp[ind][s];
        int a = 0;
        if(s + arr[ind] <= sum) {
        a = getsum(arr,n,sum,ind+1,s+ arr[ind],dp);
        }
        // s-=arr[ind];
        int b = getsum(arr,n,sum,ind+1,s,dp);
        
        return dp[ind][s] = a+b;
    }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   int dp[][] = new int[n][sum+1];
	   for(int i=0; i<n; i++){
	       Arrays.fill(dp[i],-1);
	   }
	    return getsum(arr,n,sum,0,0,dp);
	}
    public int countPartitions(int n, int d, int[] arr) {
        // code here
        int totalSum=0;
        for(int ele: arr){
            totalSum+=ele;
        }
        if(totalSum-d<0 || (totalSum-d)%2 == 1) return 0;
        return perfectSum(arr,n,(totalSum-d)/2);
    }
    public int findTargetSumWays(int[] nums, int target) {
       return countPartitions(nums.length,target,nums);
    }
}