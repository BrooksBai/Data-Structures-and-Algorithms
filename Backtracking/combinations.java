/*
  LeetCode 77. Combinations: https://leetcode.com/problems/combinations/
  Time: O(n * "n choose k") = O(n * n!/(k!*(n-k)!)). We will have "n choose k" combinations 
        and in each call we will do O(n) work in the for loop at max
  Space: O(k) (call stack) (without output)
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        exploreCombinations(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void exploreCombinations(int n, int k, int offset, List<Integer> snippet, List<List<Integer>> result) {
        // base case: "snippet" is full
        if (snippet.size() == k) {
            result.add(new ArrayList<>(snippet));
            return;
        }
        // choose/explore/unchoose
        final int spaceLeftInSnippet = k - snippet.size();
        // n - i + 1 is choices left
        for (int i = offset; i <= n && spaceLeftInSnippet <= n - i + 1; i++) {
            // choose
            snippet.add(i);
            // explore
            exploreCombinations(n, k, i + 1, snippet, result);
            // unchoose
            snippet.remove(snippet.size() - 1);
        }
    }
}