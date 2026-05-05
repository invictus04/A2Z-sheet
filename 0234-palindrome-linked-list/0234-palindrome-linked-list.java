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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null ) return true;
        Stack<Integer> st = new Stack<>();
        ListNode trav = head;
        while(trav != null){
            st.push(trav.val);
            trav = trav.next;
        }

        ListNode travRev = head;
        while(travRev != null){
            if(st.peek() != travRev.val) return false;
            st.pop();
            travRev = travRev.next;
        }
        return true;


    }
}