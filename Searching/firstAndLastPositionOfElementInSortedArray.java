
/*
  LeetCode 34. Find First and Last Position of Element in Sorted Array: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
  Time: O(log(n))
  Space: O(1)
*/
class Solution {
    private enum SearchType {
        FIRST, 
        LAST
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] rangeResult = {-1, -1};
        int leftBoundIndex = search(nums, target, SearchType.FIRST);
        // if first occurrence is not found, stop processing
        if (leftBoundIndex == -1) {
            return rangeResult;
        }
        rangeResult[0] = leftBoundIndex;
        rangeResult[1] = search(nums, target, SearchType.LAST);
        return rangeResult;
    }
    
    private int search(int[] nums, int target, SearchType searchType) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // doing int mid = (left + right) / 2 is prone to overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (searchType == SearchType.FIRST) {
                    if (isInBounds(nums, mid - 1) && nums[mid - 1] == target) {
                        right = mid - 1;
                    } else {
                        return mid;
                    }
                } else if (searchType == SearchType.LAST) {
                    if (isInBounds(nums, mid + 1) && nums[mid + 1] == target) {
                        left = mid + 1;
                    } else {
                        return mid;
                    }
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // left > right, item not found
        return -1;
    }
    
    private boolean isInBounds(int[] arr, int index) {
        return index >= 0 && index <= arr.length - 1;
    }
}