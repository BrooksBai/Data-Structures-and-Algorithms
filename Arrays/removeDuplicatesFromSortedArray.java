/*
  LeetCode 26. Remove Duplicates from Sorted Array: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
  Time: O(n)
  Space: O(1)
*/
class Solution {
    public int removeDuplicates(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}