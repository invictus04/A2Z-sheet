class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int maxi = 0;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi,candies[i]);
        }

        int left=0, right =maxi;
        while(left<right){
            int middle = (left+right+1)/2;
            if(canAllocate(candies,k,middle,n)){
                left=middle;
            } else {
                right = middle-1;
            }
        }
        
        return left;
    }

    private boolean canAllocate(int[] candies, long k, int num, int n){
        long maxi=0;
        for(int i=0; i<n; i++){
            maxi += candies[i]/num;
        }
        return maxi>=k;
    }
}