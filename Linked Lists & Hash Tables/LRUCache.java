/*
  LeetCode 146. LRU Cache: https://leetcode.com/problems/lru-cache/
  Time: O(1) for each operation
  Space: O(n), we use a hashtable to store n nodes
*/
class LRUCache {
    /** Our internal definitions of doubly linked list */
    private class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
    }
    
    private Map<Integer, DNode> hashtable = new HashMap<Integer, DNode>();
    private DNode head, tail;
    private int totalItemsInCache;
    private int capacity;

    public LRUCache(int capacity) {
        // Cache starts empty and capacity is set by client
        totalItemsInCache = 0;
        this.capacity = capacity;
        // Initialize the two sentinel node of the cache
        head = new DNode();
        head.prev = null;
        tail = new DNode();
        tail.next = null;
        // Write the head and tail together
        head.next = tail;
        tail.prev = head;
    }
    
    /** Retrieve an item from the cache */
    public int get(int key) {
        DNode node = hashtable.get(key);
        boolean itemFoundInCache = node != null;
        if (!itemFoundInCache) {
            return -1;
        }
        // Item has been accessed, move to the front of the list
        moveToHead(node);
        return node.value;
    }
    
    /** Add an item to the cache if it is not already there,
        if it is already there, update the value and move it to 
        the front of the cache
    */
    public void put(int key, int value) {
        DNode node = hashtable.get(key);
        boolean itemFoundInCache = node != null;
        if (!itemFoundInCache) {
            // Creat a new node
            DNode newNode = new DNode();
            newNode.key = key;
            newNode.value = value;
            // Add to the hashtable and doubly linked list
            hashtable.put(key, newNode);
            addNode(newNode);
            totalItemsInCache++;
            if (totalItemsInCache > capacity) {
                removeLRUEntryFromStructure();
            }
        } else {
            // if item is in cache, just update and move it to the head
            node.value = value;
            moveToHead(node);
        }
    }
    
    /** Remove the least used entry from the doubly linked list
        and the hashtable
    */
    public void removeLRUEntryFromStructure() {
        DNode tail = popTail();
        hashtable.remove(tail.key);
        totalItemsInCache--;
    }
    
    /** Pop the last item from the structure */
    private DNode popTail() {
        DNode node = tail.prev;
        removeNode(node);
        return node;
    }
    
    /** Add a node right after the dummy head node */
    private void addNode(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    /** Remove the given node from the doubly linked list */
    private void removeNode(DNode node) {
        // Grab reference to the prev and next of the node
        DNode savedPrev = node.prev;
        DNode savedNext = node.next;
        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }
    
    /** Move a node to the head of the doubly linked list */
    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */