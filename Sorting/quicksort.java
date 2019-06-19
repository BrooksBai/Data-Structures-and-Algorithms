public void quicksort(int[] arr) {
	quicksort(arr, 0, arr.length - 1);
}

private void quicksort(int[] arr, int left, int right) {
	if (left < right) {
		int pivotFinalRestingPosition = partition(arr, left, right);
		quicksort(arr, left, pivotFinalRestingPosition - 1);
		quicksort(arr, pivotFinalRestingPosition + 1, right);
	}
}

private int partition(int[] arr, int left, int right) {
	int pivot = arr[right];
	// i will keep track of the "tail" of the section of items less than the pivot
	int i = left - 1;
	for (int j = left; j < right; j++) {
		if (arr[j] < pivot) {
			i++;
			swap(arr, i, j);
		}
	}
	swap(arr, i + 1, right);
	return i + 1;
}

private void swap(int[] arr, int fisrt, int second) {
	int temp = arr[fisrt];
	arr[first] = arr[second];
	arr[second] = temp;
}