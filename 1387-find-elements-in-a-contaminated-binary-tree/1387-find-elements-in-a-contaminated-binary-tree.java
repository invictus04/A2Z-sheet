/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    HashSet<Integer> seen;
    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        dfs(root, 0);
    }
    
    public boolean find(int target) {
        return seen.contains(target);
    }
    private void dfs(TreeNode curr, int val){
        if(curr == null) return;
        seen.add(val);
        dfs(curr.left, val*2+1);
        dfs(curr.right, val*2+2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */