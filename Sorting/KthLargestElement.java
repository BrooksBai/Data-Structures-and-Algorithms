/*
  LeetCode 215. Kth Largest Element in an Array: https://leetcode.com/problems/kth-largest-element-in-an-array/
  Time: O(n)
  Space: O(1)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        Random rand = new Random();

        while (left <= right) {
            int choosenPivotIndex = left + rand.nextInt(right - left + 1);
            int finalIndexOfChoosenPivot = partition(nums, left, right, choosenPivotIndex);
            if (finalIndexOfChoosenPivot == n - k) {
                /* finalIndexOfChoosenPivot is the final postion if the array we were given
                   had been sorted. We don't need to sort the whole arrary
                 */
                return nums[finalIndexOfChoosenPivot];
            } else if (finalIndexOfChoosenPivot < n - k) {
                // K'th largest element must be in the right partition.
                left = finalIndexOfChoosenPivot + 1;
            } else {
                //finalIndexOfChoosenPivot > n - k
                // K'th largest element must be in the left partition.
                right = finalIndexOfChoosenPivot - 1;
            }
        }
        return -1; // This will never be reached, necessary to compile
    }
    
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        int lesserItemsTailIndex = left;
        swap(nums, pivotIndex, right);
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, lesserItemsTailIndex++);
            }
        }
        // place the pivot to it's final position and return the pivot's final position
        swap(nums, lesserItemsTailIndex, right);
        return lesserItemsTailIndex;
    }
    
    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}