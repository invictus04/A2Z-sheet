/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private boolean dfs(ListNode head, TreeNode root){
        if(head == null) return true;
        if(root == null) return false;
        if(head.val != root.val) return false;
        return dfs(head.next,root.left)||dfs(head.next,root.right);
    }
    private boolean check(ListNode head, TreeNode root){
        if(root == null) return false;
        if(dfs(head,root)) return true;
        
        return check(head,root.left) || check(head,root.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        return check(head,root);
    }
}