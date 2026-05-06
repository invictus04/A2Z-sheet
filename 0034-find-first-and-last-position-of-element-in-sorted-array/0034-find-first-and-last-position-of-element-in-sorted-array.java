class Solution {

    public int firstOccurence(int[] arr, int target){
        int high = arr.length-1, low = 0;
        int first = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target){
                first = mid;
                high = mid -1;
            } else if(target > arr[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return first;
    }
    public int lastOccurence(int[] arr, int target){
        int high = arr.length-1, low = 0;
        int last = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1;
            } else if(target > arr[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstOccurence(nums,target);
        ans[1] = lastOccurence(nums,target);
        return ans;
    }
}