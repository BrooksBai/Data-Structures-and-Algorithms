/**
 * LeetCode 23. Merge k Sorted Lists: https://leetcode.com/problems/merge-k-sorted-lists/
 * Time: O(n*log(k)), n = # of elememts across all lists, k = # of list in the array of lists
 * Space: O(k), we use a min heap with capacity k

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private static class MyComparator implements Comparator<ListNode> {
        public int compare(ListNode o1, ListNode o2) {
            return Integer.compare(o1.val, o2.val);
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> minHeap = new PriorityQueue<>(lists.length, new MyComparator());
        // Add smallest element of each sorted list to the Min Heap if it isn't null
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        /* Eject the current min element in the Min Heap, add it to the merged list
           and add the next element to the Min Heap where the ejected element from.
           Time: O(n*log(k)), n = # of elememts across all lists, k = # of list in the array of lists
           Space: O(k)
        */
        ListNode dummyHead = new ListNode(-1); // the value in dummy node doesn't matter
        ListNode curr = dummyHead;
        while (!minHeap.isEmpty()) {
            ListNode minItem = minHeap.poll();
            curr.next = minItem;
            curr = curr.next;
            if (minItem.next != null) {
                minHeap.add(minItem.next);
            }
        }
        return dummyHead.next;
    }
}