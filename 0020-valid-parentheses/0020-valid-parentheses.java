class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0)
            return false;
        Stack<Character> ans = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                ans.push(s.charAt(i));
            } else {
                if(ans.isEmpty()) return false;
                    char ch = ans.peek();
                    if ((s.charAt(i) == ')' && ch == '(') || (s.charAt(i) == ']' && ch == '[') || (s.charAt(i) == '}'&& ch == '{')) {
                        ans.pop();
                    } else {
                        return false;
                    }
            }
        }
        return ans.isEmpty();
    }
}