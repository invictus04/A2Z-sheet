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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return ans;
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int lvl = q.size();
            List<Integer> sub = new LinkedList<Integer>();
            for(int i=0; i<lvl; i++) {
                TreeNode node = q.poll();
                if(flag) {
                    sub.add(node.val);
                } else {
                    sub.add(0,node.val);
                }
                if(node.left !=null) q.offer(node.left);
                if(node.right !=null) q.offer(node.right);
            }
            ans.add(sub);
            flag =!flag;
        }
        return ans;
    }
}