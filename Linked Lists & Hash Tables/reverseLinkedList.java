/** 
 * LeetCode - 206. Reverse Linked List: https://leetcode.com/problems/reverse-linked-list/
 * Time: O(n)
 * Space: O(1)
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RevereIterative {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

/** 
 * Time: O(n)
 * Space: O(n) (call stack)
 */
class ReverseRecursive {
    public ListNode reverseList(ListNode head) {
        // base case:
        if (head == null || head.next == null) {
            return head;
        } else {
            // recursive case:
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}