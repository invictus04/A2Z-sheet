class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        for(int i=0; i<n; i++) {
            int j=i;
            int leftmax=0, rightmax=0;
            while(j>=0) {
                leftmax = Math.max(leftmax,height[j]);
                j--;
            }
            j=i;
            while(j<n) {
                rightmax = Math.max(rightmax,height[j]);
                j++;
            }
            water += Math.min(leftmax,rightmax) - height[i];
        }
        return water;
    }
}