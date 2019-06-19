/*
  LeetCode 46. Permutations: https://leetcode.com/problems/permutations/
  Time: O(n * n!), we have n! permutations, and we need to copy each permutaion when we hit the base case
  Space: O(n) (call stack) without output
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), result);
        return result;
    }
    
    private void permute(int[] nums, List<Integer> permutation, List<List<Integer>> result) {
        // base case: our goal
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        }
        // choose/explore/unchoose
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            // choose
            permutation.add(nums[i]);
            // explore
            permute(nums, permutation, result);
            // unchoose
            permutation.remove(permutation.size() - 1);
        }
    }
}