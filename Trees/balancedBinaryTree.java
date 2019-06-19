/**
 * LeetCode 110. Balanced Binary Tree: https://leetcode.com/problems/balanced-binary-tree/
 * Time: O(n)
 * Space: O(h), where h is the height of the tree
 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1; // we use -1 to indicate unbalanced status
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            // we use -1 to indicate unbalanced status
            return -1; 
        } else if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}