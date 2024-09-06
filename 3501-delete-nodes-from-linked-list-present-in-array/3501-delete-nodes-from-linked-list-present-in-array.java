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
    public ListNode modifiedList(int[] nums, ListNode head) {
       HashSet<Integer> hs = new HashSet<>();
       for(int i=0;i<nums.length; i++){
        hs.add(nums[i]);
       }

        if(head == null) return null;
        while(head != null && hs.contains(head.val)){
            head=head.next;
        }

        ListNode temp = head;
        while(temp.next!=null){
            if(hs.contains(temp.next.val)){
                temp.next = temp.next.next;
            } else{
                temp = temp.next;
            }
        }
    return head;

    }
}