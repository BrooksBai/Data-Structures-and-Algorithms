# LeetCode: 13. Roman to Integer: https://leetcode.com/problems/roman-to-integer/
# Time: O(n), n = the lenght of input string
# Space: O(1)

class Solution:
    def romanToInt(self, s: str) -> int:
         roman_to_int_map = {'I': 1,
                'V': 5,
                'X': 10,
                'L': 50,
                'C': 100,
                'D': 500,
                'M': 1000
               }
        result = 0
        for i in range(len(s) - 1):
            if roman_to_int_map[s[i]] < roman_to_int_map[s[i+1]]:
                result -= roman_to_int_map[s[i]]
            else:
                result += roman_to_int_map[s[i]]
        result += roman_to_int_map[s[-1]]
        return result