class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0, prev = -1;

        for(int num : hand)
            pq.add(num);
        
        while(!pq.isEmpty()){

            int currNum = pq.poll();
            if(prev == -1 || currNum - prev == 1){
                cnt++;
                prev = currNum;
            }
            else
                q.add(currNum);

            if(cnt == groupSize){
                cnt = 0;
                prev = -1;
                
                while(!q.isEmpty())
                    pq.add(q.poll());
            }
                
        }

        return (cnt > 0) ? false : true;
    }
}