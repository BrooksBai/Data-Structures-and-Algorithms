/**
 * LeetCode 236. Lowest Common Ancestor of a Binary Tree: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Time: O(n), n = total amount of nodes int the binary tree
 * Space: O(h), h = height of the binary tree
 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case 1:
        if (root == null) {
            return null;
        }
        
        // base case 2:
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        
        // recursive case: search left and then search right
        TreeNode leftSearchResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearchResult = lowestCommonAncestor(root.right, p, q);
        
        if (leftSearchResult == null) {
            return rightSearchResult;
        }
        
        if (rightSearchResult == null) {
            return leftSearchResult;
        }
        
        return root;
    }
}