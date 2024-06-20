class Solution {

    public List<String> generateParenthesis(int n) {
        String ans = "";
        List<String> res = new ArrayList<>();
        gen(res, ans, n, 0, 0);
        return res;
    }

    static public void gen(List<String> res, String ans, int n, int open, int close) {
        if (ans.length() == n * 2) {
            res.add(ans);
            return;
        }
        if (open < n) {
            gen(res, ans + "(", n, open + 1, close);
        }
        if (close < open) {
            gen(res, ans + ")", n, open, close + 1);
        }
    }
}