class Solution {
    public int nthUglyNumber(int n) {
        
    /*  TreeSet<Long> st = new TreeSet<>();
        st.add(1L);
        Long ug = 1L;
        for(int i=0; i<n; i++){
            ug = st.pollFirst();
            st.add(ug*2);
            st.add(ug*3);
            st.add(ug*5);
        }
        return ug.intValue();
    */

    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    Set<Long> seen = new HashSet<>();
    int [] prime = {2,3,5};

    minHeap.offer(1L);
    seen.add(1L);

    long ug = 1L;
    for(int i =0; i<n; i++){
        ug = minHeap.poll();

        for(int p: prime){
            long next = ug*p;
            if(seen.add(next)){
                minHeap.offer(next);
            }
        }
    }

    return (int) ug;
    }
}