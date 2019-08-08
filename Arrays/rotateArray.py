# LeetCode 189. Rotate Array: 189. Rotate Array
# Time: O(n)
# Space: O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)
        
    def reverse(self, nums: List[int], start: int, end: int) -> None:
        """
        reverse a array (end inclusively)
        """
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1