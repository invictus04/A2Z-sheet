class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
       int left =0; 
       int right =0;
       int k =0;

       while(left < nums1.length && right < nums2.length) {
        if(nums1[left] < nums2[right]) left++;
        else if(nums1[left]> nums2[right]) right++;
        else {
            nums1[k++] = nums1[left++];
            right++;
        }
       }
  
        return Arrays.copyOfRange(nums1,0,k);
    }
}