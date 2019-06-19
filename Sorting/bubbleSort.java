/*
  This is Bubble Sort with the best case still being O(n^2).
*/
public void rawBubbleSort(int[] arr) {
	for (int i = arr.length - 1; i > 0; i--) {
		for (int j = 0; j < i; j++) {
			if (arr[j] > arr[j + 1]) {
				swap(arr, j, j + 1);
			}
		}
	}
}

/*
  This is an implementation of Bubble Sort that improves the best case to O(n) time.

  It also improves the average case's amount of comparisons
  but it does NOT change the asymptotic complexity of the average case.
  
  We use the local variable t to indicate the index that the last swap happend.
*/
public void bubbleSort(int[] arr) {
	int i = arr.length - 1; // the index we are bubbling up to
	while (i > 0) {
		int t = 0; // the index that the last swap happened
		for (int j = 0; j < i; j++) {
			if (arr[j] > arr[j + 1]) {
				swap(arr, j, j + 1);
				t = j + 1; // the last swap happened at index j + 1
			}
		}
		i = t - 1; // everything past the index i is sorted
	}
}

private void swap(int[] arr, int first, int second) {
	int temp = arr[first];
	arr[first] = arr[second];
	arr[second] = temp;
}