class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0, ele = 0;
        int maj = n / 2;

        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                ele = nums[i];
            }
            if (ele != nums[i]) {
                cnt--;
            } else {
                cnt++;
            }
        }
        return ele;

    }
}