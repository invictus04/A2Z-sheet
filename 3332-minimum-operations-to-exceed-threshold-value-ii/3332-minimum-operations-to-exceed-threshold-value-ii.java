class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int cnt=0;
        for(int num: nums){
            pq.offer((long)num);
        }

        int operations=0;
        while(pq.size()>1 && pq.peek() < k){
            long first = pq.poll();
            long second = pq.poll();
            long ele = first*2+second;
            pq.offer(ele);
            operations++;
        }
        return operations;
    }
}