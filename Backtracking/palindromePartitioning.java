/*
  LeetCode 131. Palindrome Partitioning
  https://leetcode.com/problems/palindrome-partitioning/
  Time: O(n*(2^n)), n = the length of the string, worst case, Ex: "aaaa"
        We are basically taking subsets, so (2^n), and the O(n) time to copy array to our answer.
  Space: O(n) (call stack)
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> validDecompositions = new ArrayList<>();
        List<String> decomposeInProgress = new ArrayList<>();
        decomposeString(s, 0, decomposeInProgress, validDecompositions);
        return validDecompositions;
    }
    
    private void decomposeString(String s, int buildPointer, List<String> decomposeInProgress, List<List<String>> validDecompositions) {
        if (buildPointer == s.length()) {
            validDecompositions.add(new ArrayList<>(decomposeInProgress)); // deep copy the list, this is key.
        } else {
            for (int i = buildPointer; i < s.length(); i++) {
                if (isPalindrome(s, buildPointer, i)) {
                    // choose
                    String palindromicSnippet = s.substring(buildPointer, i + 1);
                    decomposeInProgress.add(palindromicSnippet);
                    
                    // explore
                    decomposeString(s, i + 1, decomposeInProgress, validDecompositions);
                    
                    // un-choose
                    decomposeInProgress.remove(decomposeInProgress.size() - 1);
                }
            }
        }
    }
    
    /* Check if the region from left (inclusive) to right (incusive) is a palindrome. */
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}