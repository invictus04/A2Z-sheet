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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merger(left, right);
    }

    private ListNode getMid(ListNode head){
        ListNode prev = null;
        while(head != null && head.next != null) {
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null;
        return mid;
    }

    private ListNode merger(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }   
}