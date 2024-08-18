class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> st = new TreeSet<>();
        st.add(1L);
        Long ug = 1L;
        for(int i=0; i<n; i++){
            ug = st.pollFirst();
            st.add(ug*2);
            st.add(ug*3);
            st.add(ug*5);
        }
        return ug.intValue();
    }
}