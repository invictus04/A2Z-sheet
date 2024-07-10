class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int[] arr) {
       int [] nextS = nextSmall(arr);
        int [] prevS = prevSmall(arr);
        long count=0;
 
        for(int i=0; i<arr.length; i++) {
            int first = i-prevS[i];
            int last = nextS[i] - i;
            long prod = first*last;
            prod = prod*arr[i];
            count = count + prod;
        }
        return count;   
    }
    public long sumSubarrayMax(int[] arr) {
       int [] nextS = nextLarge(arr);
        int [] prevS = prevLarge(arr);
        long count=0;
 
        for(int i=0; i<arr.length; i++) {
            int first = i-prevS[i];
            int last = nextS[i] - i;
            long prod = first*last;
            prod = prod*arr[i];
            count = count + prod;
        }
        return count;   
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
    private int[] nextLarge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
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

    private int[] prevLarge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
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