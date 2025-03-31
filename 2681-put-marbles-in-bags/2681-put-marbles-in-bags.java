class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int pairweight[] = new int[n-1];
        for(int i=0; i<n-1; i++){
            pairweight[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(pairweight,0,n-1);
        long diff=0;
        for(int i=0; i<k-1; i++){
            diff += pairweight[n-2-i]-pairweight[i];
        }
        return diff;

    }
}