/*
  Selection Sort. Best Case/Average Case/Worst Case Time Complexities are all O(n^2)
*/
public void selectionSort(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
		int min = i;
		for (int j = i + 1; j < arr.length; j++) {
			if (a[j] < a[min]) {
				min = j;
			}
		}
		swap(arr, i, min);
	}
}

private void swap(int[] arr, int first, int second) {
	int temp = arr[first];
	arr[first] = arr[second];
	arr[second] = temp;
}