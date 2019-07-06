/* 
  LeetCode 80. Remove Duplicates from Sorted Array II: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
  Time: O(n)
  Space: O(1)
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}