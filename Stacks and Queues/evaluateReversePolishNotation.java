/*
  LeetCode 150. Evaluate Reverse Polish Notation: https://leetcode.com/problems/evaluate-reverse-polish-notation/
  Time: O(n), n = the # of operands(numbers) + the # of operators(+, -, *, /)
  Space: O(d), d = the # of operands(numbers)
*/

class Solution {
    /* We assume we get a vlaid Reverse Polish Notation expression encoded
       in the string array
    */
    public int evalRPN(String[] tokens) {
        int firstOperand;
        int secondOperand;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                secondOperand = stack.pop();
                firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }  else if(token.equals("/")) {
                secondOperand = stack.pop();
                firstOperand = stack.pop();
                stack.push(firstOperand / secondOperand);
            } else { // token is a digit
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}