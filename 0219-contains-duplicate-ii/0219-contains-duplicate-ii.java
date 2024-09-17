class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(!hash.containsKey(nums[i])){
                hash.put(nums[i], i);
            } else {
                int ind = hash.get(nums[i]);
                    if(Math.abs(ind-i)<= k) return true;
                hash.put(nums[i], i);    
            }
        }
        return false;
    }
}