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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int cnt=0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        temp = head;
        ListNode[] ans = new ListNode[k];
        int parts = cnt/k;
        int extra = cnt%k;

       for(int i=0; i<k; i++){
        if(temp == null) break;
        ans[i] = temp;
        ListNode prev = null;
        for(int j=0; j<parts; j++){
            prev = temp;
            temp = temp.next;
        }
        if(extra>0){
            prev = temp;
            temp = temp.next;
            extra--;
        }
        prev.next = null;
       }

        return ans;
    }
}