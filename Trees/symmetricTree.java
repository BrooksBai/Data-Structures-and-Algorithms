/**
 * LeetCode 101. Symmetric Tree: https://leetcode.com/problems/symmetric-tree/
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
    public boolean isSymmetric(TreeNode root) {
        return root == null || check(root.left, root.right);
    }
    
    private boolean check(TreeNode leftSub, TreeNode rightSub) {
        if (leftSub == null && rightSub == null) {
            return true;
        } else if (leftSub == null || rightSub == null) {
            return false;
        } else {
            return leftSub.val == rightSub.val
                && check(leftSub.left, rightSub.right)
                && check(leftSub.right, rightSub.left);
        }
    }
}