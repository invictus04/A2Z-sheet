class Solution {
    public int sumSubarrayMins(int[] arr) {
        int [] nextS = nextSmall(arr);
        int [] prevS = prevSmall(arr);
        int mod = 1000000007;
        long count=0;

        for(int i=0; i<arr.length; i++) {
            int first = i-prevS[i];
            int last = nextS[i] - i;
            long prod = (first*last)%mod;
            prod = (prod*arr[i])%mod;
            count = (count%mod + prod)%mod;
        }
        return (int)count;   
    }
    private int[] nextSmall(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
    return ans;
    }

    private int[] prevSmall(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
    return ans;
    }
}