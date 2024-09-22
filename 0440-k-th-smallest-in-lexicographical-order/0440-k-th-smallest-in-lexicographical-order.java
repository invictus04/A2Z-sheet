class Solution {
    private int count(int curr, int n){
        int steps = 0;
        long first = curr,last = curr;
        while(first <= n){
            steps += Math.min(n,last) - first +1;
            first *= 10;
            last = last*10+9;
        }
        return steps;
    }
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while(k>0){
            int steps = count(curr,n);

            if(steps <= k){
                curr++;
                k-=steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
}