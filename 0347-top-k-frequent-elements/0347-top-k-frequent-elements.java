class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i: nums){
            mpp.put(i, mpp.getOrDefault(i,0)+1);
        }

        int[] ans = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> mpp.get(a) - mpp.get(b));
        for(int num: mpp.keySet()){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int index=0;     
        while(!pq.isEmpty()){
            ans[index++] = pq.poll();
        }
        return ans;
    }
}