class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char i: num.toCharArray()) {
            while(!st.isEmpty() && k>0 && st.peek() > i){
                st.pop();
                k--;
            }
            st.push(i);
        }

        while(k>0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        ans.reverse();
        while(ans.length()>0 && ans.charAt(0)=='0') ans.deleteCharAt(0);
        return ans.length()>0 ? ans.toString():"0";
    }
}