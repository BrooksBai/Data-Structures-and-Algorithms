class MinHeap {
	private int capacity = 10;
	private int size;
	private heap[];

    /*
      We could make a caller set the capacity but let's just
      keep it internally defaulting for now
    */
    public MinHeap() {
      	heap = new int[capacity];
    }

    public boolean isEmpty() {
    	return size == 0;
    }

	public int peek() {
		if (isEmpty()) { throw new IllegalStateException(); }
	  	return heap[0];
	}

	/*
	  This is a min heap.
	  remove() will remove and return the smallest item. 
	*/
	public int remove() {
	  	if (isEmpty()) { throw new IllegalStateException(); }

	  	/*
	  	  -> Grab the min item. It is at index 0.
	  	  -> Move the last item in the heap to the "top" of the heap at index 0.
	  	  -> Reduce size
	  	*/
	  	int minItem = heap[0];
	  	heap[0] = heap[size - 1];
	    size--;
	  	// Restore the heap
		heapifyDown();
	  	return minItem;
	}

    /*
      Add an item to the min heap
    */
    public void add(int itemToAdd) {
    	ensureExtraCapacity();
	    /*
	  	  -> Place the item at the bottom, far right, of the
	  	  conceptual binary heap structure
	  	  -> Increment size
	  	*/
	  	heap[size] = itemToAdd;
	  	size++;
	  	// Restore the heap
	  	heapifyUp();
	}

	/*
      Bubble down the item we just swapped to the "top" of the heap
      after a removal operation
    */
	private void heapifyDown() {
		
        int index = 0;

        while (hasLeftChild(index)) {
        	int smallerChildIndex = getLeftChildIndex(index);
        	if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
        		smallerChildIndex = getRightChildIndex(index);
        	}

        	if (heap[index] < heap[smallerChildIndex]) {
        		break;
        	} else {
        		swap(index, smallerChildIndex);
        	}

        	index = smallerChildIndex;
        }
	}

    /*
      Bubble up the item we inserted at the "end" of the heap
    */
	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > heap[index]) {
			swap(index, getParentIndex[index]);
			index = getParentIndex[index];
		}
	}

	private void swap(int first, int second) {
		int temp = heap[first];
		heap[first] = heap[second];
		heap[second] = temp;
	}

	/*
	  If heap is full then double capacity
	*/
	private void ensureExtraCapacity() {
		is (size == capacity) {
			heap = Arrays.copyOf(heap, capacity * 2);
			capacity *= 2;
		}
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		retrun 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return heap[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return heap[getParentIndex(index)];
	}
}