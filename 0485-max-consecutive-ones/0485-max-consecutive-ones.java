class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                count++;
                System.out.println(i + " -> "+ count);
            } else {
                maxi = Math.max(maxi,count);
                count = 0;
            }
        }
        maxi = Math.max(count,maxi);
        return  maxi;
    }
}