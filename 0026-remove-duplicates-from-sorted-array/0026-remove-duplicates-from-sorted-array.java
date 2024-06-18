class Solution {
    public int removeDuplicates(int[] nums) {
        int front = 1;
        int back = 0;
        int cnt =1;
        while(front<nums.length) {
            if(nums[front] != nums[back]){
                nums[cnt] = nums[front];
                cnt++;
            }
            front++;
            back++;
        }
        return cnt;

    }
}