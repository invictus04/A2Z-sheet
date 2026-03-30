class Solution {
    public boolean binarySearch(int arr[], int target, int low, int high){
        while(low<=high){
            int mid = (low+high)/2;
            System.out.println(mid);
            if(arr[mid] == target){
                return true;
            } else if(target > arr[mid]){
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++){
            if(target >= matrix[i][0] && target <= matrix[i][m-1]){
                // System.out.println("Inside this");
                return binarySearch(matrix[i],target,0,m-1);
            }
        }
        return false;
    }
}