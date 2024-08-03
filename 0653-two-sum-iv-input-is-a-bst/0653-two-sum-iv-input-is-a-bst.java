/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> bst = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isreverse) {
        reverse = isreverse;
        push(root);
    }

    public void push(TreeNode root) {
        while (root != null) {
            bst.push(root);
            if (reverse == true) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    public int next() {
        TreeNode temp = bst.pop();
        if (reverse == false) {
            push(temp.right);
        } else {
            push(temp.left);
        }
        return temp.val;
    }

    public boolean hasNext() {
        return !bst.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i<j) {
            if(i+j == k) return true;
            else if(i+j<k){
                i=l.next();
            } else {
                j=r.next();
            }
        }
        return false;
    }
}