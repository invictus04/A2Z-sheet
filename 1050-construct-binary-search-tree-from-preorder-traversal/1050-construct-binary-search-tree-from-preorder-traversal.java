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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorder(int [] preorder, int bound, int [] arr) {
        if(arr[0] == preorder.length || preorder[arr[0]]>bound) return null;

        TreeNode ans = new TreeNode(preorder[arr[0]++]);
        ans.left = bstFromPreorder(preorder,ans.val,arr);
        ans.right = bstFromPreorder(preorder,bound,arr);
        return ans;
    }
}