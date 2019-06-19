/*
  LeetCode 17. Letter Combinations of a Phone Number: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
  Time: O(n*4^n), n = the length of the give digits string
  Space: O(n) (call stack) without output
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() != 0) {
            letterCombinations(digits, 0, "", result);
        }
        return result;
    }
    
    Map<String, String> mapping = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    
    private void letterCombinations(String digits, int decisionPoint, String partialCombinations, List<String> result) {
        // base case: our goal
        if (decisionPoint == digits.length()) {
            result.add(partialCombinations);
        } else {
            String digit = digits.substring(decisionPoint, decisionPoint + 1);
            String letters = mapping.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                // choose
                String letter = letters.substring(i, i + 1);
                // explore
                letterCombinations(digits, decisionPoint + 1, partialCombinations + letter, result);
            }
        }
    }
}