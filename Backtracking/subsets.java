/*
  LeetCode 78. Subsets: https://leetcode.com/problems/subsets/
  Time: O(n*2^n), n = # of the distinct integer
  Space: O(n) withou output, (call stack)
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), powerSet);
        return powerSet;
    }
    
    private void subsets(int[] nums, int decisionPoint, List<Integer> selectedSoFar, List<List<Integer>> powerSet) {
        // base case: our goal
        if (decisionPoint == nums.length) {
            powerSet.add(new ArrayList<>(selectedSoFar));
        } else {
            // make a choice: add it
            selectedSoFar.add(nums[decisionPoint]);
            // explore (the remainging choices)
            subsets(nums, decisionPoint + 1, selectedSoFar, powerSet);
            // undo our choice
            selectedSoFar.remove(selectedSoFar.size() - 1);
            // make a choice: not add it
            // explore
            subsets(nums, decisionPoint + 1, selectedSoFar, powerSet);
        }
    }
}