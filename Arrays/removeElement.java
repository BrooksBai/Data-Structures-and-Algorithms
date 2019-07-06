/*
  LeetCode 27. Remove Element: https://leetcode.com/problems/remove-element/
  Time: O(n)
  Space: O(1)
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index++] = num;
            }
        }
        return index;
    }
}