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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((val1,val2) -> {return val1.val - val2.val;});

        for(int i=0; i<lists.length; i++){
            if(lists[i] != null){

            pq.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = temp.next;

            if(curr.next != null){
                pq.offer(curr.next);
            }
        }


        return dummy.next;
    }
}