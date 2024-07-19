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
    TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> mp;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return null;
       mp = new TreeMap<>();
        dfs(root,0,0);
        List<List<Integer>> res = new LinkedList<>();
        for(int key: mp.keySet()){
            List<Integer> list = new LinkedList<>();
            TreeMap<Integer, PriorityQueue<Integer>> tm = mp.get(key);
            for(int k: tm.keySet()) {
                PriorityQueue<Integer> pq = tm.get(k);
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
    return res;
    }

    private void dfs(TreeNode root, int ind, int level) {
        if(root == null) return;

        mp.putIfAbsent(ind,new TreeMap<>());
        mp.get(ind).putIfAbsent(level,new PriorityQueue<>());
        mp.get(ind).get(level).add(root.val);
        dfs(root.left,ind-1,level+1);
        dfs(root.right,ind+1,level+1);
    }
}