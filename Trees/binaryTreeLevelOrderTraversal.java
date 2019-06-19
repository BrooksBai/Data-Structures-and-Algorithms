/**
 * LeetCode 102. Binary Tree Level Order Traversal: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Time: O(n), where n is the total amount of nodes in the binary tree
 * Space: O(n)

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> levelsList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root node to start the breadth first search
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLayer = new ArrayList<>();
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLayer.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            levelsList.add(currentLayer);
        }
        return levelsList;
    }
}