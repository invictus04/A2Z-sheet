class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n1- n2);
        //min heap = kthlargest
        //max heap = kthSmallest

        // for(int i=0; i<k; i++){
        //     pq.add(nums[i]);            
        // }

        // for(int i=k; i<nums.length; i++){
        //     if(nums[i] > pq.peek()){
        //         pq.poll();
        //         pq.add(nums[i]);
        //     }
        // }

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }

        for(int i=1; i<=nums.length-k; i++){
            pq.poll();
        }

        return pq.peek();
    }
}