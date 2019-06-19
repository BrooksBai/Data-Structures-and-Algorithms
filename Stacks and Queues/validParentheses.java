/*
  LeetCode 20. Valid Parentheses: https://leetcode.com/problems/valid-parentheses/
  Time: O(n)
  Space: O(n)
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> leftChars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                leftChars.push(c);
            } else {
                if (leftChars.empty()) { // Unmatched right char, Ex: "())", ")"
                    return false;
                }
                if (c == ')' && leftChars.pop() != '(' ||
                    c == '}' && leftChars.pop() != '{' ||
                    c == ']' && leftChars.pop() != '[') {
                    return false;
                }
            }
        }
        return leftChars.empty(); // Unmatched left char. Ex: "(()"
    }
}