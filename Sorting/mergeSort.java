/**
 * LeetCode 148. Sort List: https://leetcode.com/problems/sort-list/
 * Time: O(nlog(n))
 * Space: O(1)

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMiddleAndSplitInHalf(head);
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(mid);
        return merge(leftHalf, rightHalf);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode endOfSortedList = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                endOfSortedList.next = l1;
                l1 = l1.next;
            } else {
                endOfSortedList.next = l2;
                l2 = l2.next;
            }
            endOfSortedList = endOfSortedList.next;
        }
        if (l1 != null) {
            endOfSortedList.next = l1;
        }
        if (l2 != null) {
            endOfSortedList.next = l2;
        }
        return dummyHead.next;
    }
    
    /* Get the middle and split the linked list in half */
    private ListNode getMiddleAndSplitInHalf(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Cut the end of the first list in half
        prev.next = null;
        // Slow points to the middle of the list
        return slow;
    }
}