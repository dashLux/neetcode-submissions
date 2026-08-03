/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 l1 and l2 have the same length
 l1 is longer -> l2.end.next = l1.curr
 l2 is longer -> l1.end.next = l2.curr


 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 == null) {
                head.next = list1;
                return dummy.next;
            }
            else if (list1 == null && list2 != null) {
                head.next = list2;
                return dummy.next;
            }
            else {
                if (list1.val < list2.val) {
                    head.next = list1;
                    list1 = list1.next;
                    head = head.next;
                }
                else {
                    head.next = list2;
                    list2 = list2.next;
                    head = head.next;
                }
            }
            
        }
        return dummy.next;
    }
}