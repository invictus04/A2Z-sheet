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
    public ListNode removeElements(ListNode head, int val) {
        // if(head.next == null && head.val == val) return null;
        while(head != null && head.val == val) head = head.next;
        if(head == null) return null;
        ListNode temp1 = head.next;
        ListNode temp2 = head; 
        while(temp1 != null ){
            if(temp1.val == val){
                temp2.next = temp1.next;
                temp1.next= null;
                temp1 = temp2.next;
            } else {
            temp1 = temp1.next;
            temp2 = temp2.next;
            }
        }
        if(temp2.val == val) head = null;

        return head;
    }
}