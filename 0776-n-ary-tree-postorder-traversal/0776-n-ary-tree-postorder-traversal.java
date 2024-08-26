/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void post(Node root, List<Integer> ans){
        for(Node child: root.children){
            post(child,ans);
        }
            ans.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        post(root,ans);
        return ans;
    }
}