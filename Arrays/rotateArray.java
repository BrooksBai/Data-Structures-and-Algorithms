/*
  LeetCode 189. Rotate Array: https://leetcode.com/problems/rotate-array/
*/
class Solution {
	/*
	  Time: O(n)
      Space: O(n)
	*/
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = temp[i];
        }
    }

    /*
      Space improved solution
      Time: O(n)
      Space: O(1)
    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }}
