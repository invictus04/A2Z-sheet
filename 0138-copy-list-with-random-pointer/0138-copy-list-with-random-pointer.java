/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    void copyNode(Node head) {
        Node temp = head;
        while(temp!= null) {
            Node nextEle = temp.next;
            Node copyNode = new Node(temp.val);
            copyNode.next = nextEle;
            temp.next = copyNode;
            temp = nextEle;
        }
    }

    void connectingRandom(Node head) {
         Node temp = head;
        while(temp!= null){
            Node copyNode = temp.next;
            if(temp.random != null) {
                copyNode.random = temp.random.next;
            } else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }
    public Node copyRandomList(Node head) {
        copyNode(head);
        connectingRandom(head);
        
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(temp!= null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
        
    }
}