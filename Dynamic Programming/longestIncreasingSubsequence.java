/*
  LeetCode 300. Longest Increasing Subsequence: https://leetcode.com/problems/longest-increasing-subsequence/
  Time: O(n^2), n = lenght of the array, for each of the n elements, we will solve the LIS problems which takes O(n) time,
  therefore we will take O(n^2) runtime overall.
  Space: O(n), we will store our answers for each of the n LIS subproblems.
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] maxLength = new int[nums.length];
        Arrays.fill(maxLength, 1);
        
        int maximumSoFar = 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }
            maximumSoFar = Math.max(maximumSoFar, maxLength[i]);
        }
        return maximumSoFar;
    }
}