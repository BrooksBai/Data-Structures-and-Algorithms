# LeetCode 12. Integer to Roman: https://leetcode.com/problems/integer-to-roman/
# Time: O(1)
# Space: O(1)

class Solution:
    def intToRoman(self, num: int) -> str:
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        numerals = ['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
        
        result = ""
        for value, numeral in zip(values, numerals):
            while num >= value:
                result += numeral
                num -= value
        return result