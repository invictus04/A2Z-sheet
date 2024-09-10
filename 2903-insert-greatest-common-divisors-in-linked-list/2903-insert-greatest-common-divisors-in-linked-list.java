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
    private int gcd(int a, int b){
        while(b!=0){
            if(a>b){
                a = a-b;
            } else {
                b = b-a;
            }
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode front = head;
        ListNode back = head;
        while(front.next != null){
            front = front.next;
            ListNode newNode = new ListNode(gcd(front.val,back.val));
            back.next = newNode;
            newNode.next = front;
            back = back.next.next;
        }

        return head;
    }
}