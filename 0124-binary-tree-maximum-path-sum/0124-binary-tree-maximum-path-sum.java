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
class Solution {
    public int findMaxSumPath(TreeNode root, int [] maxvalue) {
        if(root == null) return 0;
        int lf = Math.max(findMaxSumPath(root.left, maxvalue),0);
        int rt = Math.max(findMaxSumPath(root.right, maxvalue),0);
        maxvalue[0] = Math.max(root.val+lf+rt,maxvalue[0]);
        return root.val + Math.max(lf,rt);

    }
    public int maxPathSum(TreeNode root) {
        int maxvalue[] = new int[1];
        maxvalue[0] = Integer.MIN_VALUE;
        findMaxSumPath(root,maxvalue);
        return maxvalue[0];
    }
}