class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        Set<Integer> taken = new HashSet<Integer>();

        for(int i = 0; i<nums.length; i++){
            if(taken.contains(nums[i])) continue;

            if(minHeap.size() == 3){
                if(minHeap.peek()<nums[i]){
                    taken.remove(minHeap.poll());
                    minHeap.add(nums[i]);
                    taken.add(nums[i]);
                }
            } else {
                minHeap.add(nums[i]);
                taken.add(nums[i]);
            }
        }

        if(minHeap.size() == 1){
            return minHeap.peek();
        } else if(minHeap.size() == 2){
            int firstNum = minHeap.poll();
            return Math.max(firstNum, minHeap.peek());
        }
        return minHeap.peek();
    }
}