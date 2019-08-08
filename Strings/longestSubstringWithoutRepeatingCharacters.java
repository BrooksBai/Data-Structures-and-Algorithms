/*
  LeetCode 3. Longest Substring Without Repeating Characters: 
  https://leetcode.com/problems/longest-substring-without-repeating-characters/
  Time: O(n) 
  Space: O(1), there are only 26 characters in total possible in our set
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // use sliding window technique
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            if (set.add(s.charAt(right))) { // expand our window
                right++;
                max = Math.max(max, right - left);
            } else { // shift our window
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }
}