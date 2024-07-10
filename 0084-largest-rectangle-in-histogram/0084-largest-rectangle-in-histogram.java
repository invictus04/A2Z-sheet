class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] right = rightSmall(heights);
        int [] left = leftSmall(heights);

        int max =0;
        for(int i=0; i<heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i]-left[i]+1));
        }
        return max;

    }
    private int[] rightSmall(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans[i] = arr.length-1;
            } else {
                ans[i] = st.peek()-1;
            }
            st.push(i);
        }
    return ans;
    }

    private int[] leftSmall(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek()+1;
            }
            st.push(i);
        }
    return ans;
    }
}