class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0, sum = 0, r = 0, n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        while(r < n){
            sum += nums[r++];
            if(sum == goal) ans++;
            if(h.get(sum - goal) != null) ans += h.get(sum - goal);
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}