/*
  LeetCode 22. Generate Parentheses: https://leetcode.com/problems/generate-parentheses/
  Time: ? pretty involved
  Space: O(2n) = O(n) (call stack), n = # of pairs of parentheses given
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, "", result);
        return result;
    }
    
    private void generateParenthesis(int numLeftParensNeeded, int numRightParensNeeded, String parenStringInProgress, List<String> result) {
        // base case: we have used all left and right parens necessary within constraints
        if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
            result.add(parenStringInProgress);
        } else {
            // Can we insert "(" ? 
            if (numLeftParensNeeded > 0) {
                generateParenthesis(numLeftParensNeeded - 1, numRightParensNeeded, parenStringInProgress + "(", result);
            }
            // Can we insert ")" ? 
            if (numLeftParensNeeded < numRightParensNeeded) {
                generateParenthesis(numLeftParensNeeded, numRightParensNeeded - 1, parenStringInProgress + ")", result);
            }
        }
    }
}