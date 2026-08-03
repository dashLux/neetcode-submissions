/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 prev, curr, runner(n steps ahead)

 - prev = dummy node, prev.next = head initially
 - curr = head
 - runner

 when (runner == null) {
    curr lands on the node to be deleted
    prev lands on the previous node of curr

    prev.next = curr.next

 }

 when (n == list.length) {
    deleting the head
    
 }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode runner = head;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        for(int i = 0; i < n; i++) {
            runner = runner.next;
        }

        while (runner != null) {
            runner = runner.next;
            curr = curr.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return dummy.next;
    }
}
