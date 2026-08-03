/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 H->a->b->c

 curr, prev

 originalNext = curr.next
 curr.next = prev

 prev = curr
 curr = originalNext



 
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode originalNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = originalNext;
        }
        return prev;
        
    }
}
