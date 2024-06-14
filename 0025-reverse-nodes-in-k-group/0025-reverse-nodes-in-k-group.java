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
class Solution {
    public ListNode getkthNode(ListNode temp, int k){
        k-=1;
        while(temp!= null && k>0){
           k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp !=null){
            ListNode kthNode = getkthNode(temp,k);
            if(kthNode == null){
                if(prevLast != null) prevLast.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
        
    }
}