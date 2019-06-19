/*
  Insertion Sortion
  Time: O(n^2)
  Space: O(1)
*/
public void insertionSort(int[] arr) {
	for (int i = 1; i < arr.length; i++) {
		int temp = arr[i];
		int j = i - 1;
		while (j >= 0 && temp < a[j]) {
			a[j + 1] = a[j];
			j--;
		}
		a[j + 1] = temp;
	}
}