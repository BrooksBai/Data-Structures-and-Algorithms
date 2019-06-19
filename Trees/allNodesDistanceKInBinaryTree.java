/**
 * LeetCode 863. All Nodes Distance K in Binary Tree: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * Time: O(n), n = total amount of nodes in the tree 
 * Space: O(n), we have a queue and a hashtable upper bounded by n items.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        populateNodeToParentMap(nodeToParentMap, root, null);

        // Create the queue that we will use for the breadth first search
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        // Use set seen to record the TreeNode that have been seen
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        // When our search starts, we are standing at layer 0 
        int currentLayer = 0;
        while (!queue.isEmpty()) {
            if (currentLayer == K) {
                return extractLayerFromQueue(queue);
            }

            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                }

                TreeNode parent = nodeToParentMap.get(currentNode);
                if (parent != null && !seen.contains(parent)) {
                    seen.add(parent);
                    queue.offer(parent);
                }
            }
            currentLayer++;
        }
        return new ArrayList<>(); // nothing found
    }
    
    private void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap, TreeNode node, TreeNode parent) {
        if (node != null) {
            nodeToParentMap.put(node, parent);
            populateNodeToParentMap(nodeToParentMap, node.left, node);
            populateNodeToParentMap(nodeToParentMap, node.right, node);
        }
    }
    
    private List<Integer> extractLayerFromQueue(Queue<TreeNode> queue) {
        List<Integer> extractedList = new ArrayList<>();
        for (TreeNode node : queue) {
            extractedList.add(node.val);
        }
        return extractedList;
    }
}