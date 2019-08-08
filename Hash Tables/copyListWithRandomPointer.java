/*
 * LeetCode - 138. Copy List with Random Pointer: 138. Copy List with Random Pointer
 * Time: O(n)
 * Space: O(n)

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // Our clone map. We map the original node to its clone.
        Map<Node, Node> cloneMap = new HashMap<Node, Node>();
        /* 1st pass.
           Give all nodes their clone in the mapping
        */
        Node curr = head;
        while (curr != null) {
            cloneMap.put(curr, new Node(curr.val, curr.next, curr.random));
            curr = curr.next;
        }
        // 2nd pass, copy the next and random pointer
        curr = head;
        while (curr != null) {
            cloneMap.get(curr).next = cloneMap.get(curr.next);
            cloneMap.get(curr).random = cloneMap.get(curr.random);
            curr = curr.next;
        }
        return cloneMap.get(head);
    }
}