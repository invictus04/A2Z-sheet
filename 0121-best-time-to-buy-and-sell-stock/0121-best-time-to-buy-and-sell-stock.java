class Solution {
    public int maxProfit(int[] prices) {
        int maxi=0;
        int buy=prices[0];
        for(int i=1; i<prices.length; i++){
            if(buy>prices[i]){
                buy = prices[i];
            } else  {
                maxi = Math.max(maxi,prices[i]-buy);
            }
        }
        return maxi;
    }
}