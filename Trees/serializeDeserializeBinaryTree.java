/**
 * LeetCode 297. Serialize and Deserialize Binary Tree: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Time: O(n)
 * Space: O(h)

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String NULL_SYMBOL = "null";
    private static final String DELIMITER = ",";  
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // base case:
        if (root == null) {
            return NULL_SYMBOL + DELIMITER;
        }
        // recursive case:
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        
        return root.val + DELIMITER + leftSerialized + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeftToMaterialize = new LinkedList<>();
        nodesLeftToMaterialize.addAll(Arrays.asList(data.split(DELIMITER)));
        return deserializeHelper(nodesLeftToMaterialize);
    }
    
    private TreeNode deserializeHelper(Queue<String> nodesLeftToMaterialize) {
        String valueForNode = nodesLeftToMaterialize.poll();
        if (valueForNode.equals(NULL_SYMBOL)) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
        newNode.left = deserializeHelper(nodesLeftToMaterialize);
        newNode.right = deserializeHelper(nodesLeftToMaterialize);
        return newNode;
    }
}