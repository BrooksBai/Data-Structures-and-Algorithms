/*
   LeetCode 133. Clone Graph: https://leetcode.com/problems/clone-graph/
   Time: O(V+E),  V = total vertices, E = total edges
   Space: O(V)

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        /* vertexMap: Map the original vertex to its clone
           queue: Our queue for Breadth First Search
        */
        Map<Node, Node> vertexMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(node);
        vertexMap.put(node, new Node(node.val, new ArrayList<>()));
        
        while (!queue.isEmpty()) {
            Node currVertex = queue.remove();
            for (Node neighbor : currVertex.neighbors) {
                if (!vertexMap.containsKey(neighbor)) {
                    vertexMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                // Draw the edge from currVertex's clone to neighbors clone.
                vertexMap.get(currVertex).neighbors.add(vertexMap.get(neighbor));
            }
        }
        
        return vertexMap.get(node);
    }
}