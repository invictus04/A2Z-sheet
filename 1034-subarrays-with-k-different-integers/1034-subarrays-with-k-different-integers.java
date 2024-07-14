class Solution {

    public int cntSub(int[] nums, int k) {
        int l = 0, r = 0, cnt = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        while (r < nums.length) {
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);
            while (mpp.size() > k) {
                mpp.put(nums[l], mpp.get(nums[l]) - 1);
                if (mpp.get(nums[l]) == 0) {
                    mpp.remove(nums[l]);
                }
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return cntSub(nums,k)-cntSub(nums, k - 1);
    }
}