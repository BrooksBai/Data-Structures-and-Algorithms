/*
  LeetCode 74. Search a 2D Matrix: https://leetcode.com/problems/search-a-2d-matrix/
  Time: O(log(m * n))
  Space: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;
        
        int left = 0;
        int right = totalRows * totalColumns - 1;
        
        while (left <= right) {
            // prevent overflow, find the middle this way instead of doing: (left + right) / 2
            int middle = left + (right - left) / 2;
            /* 
              map from our conceptualized 1D array back to 2D Matrix to index into it
            */
            int middleElementValue = matrix[middle / totalColumns][middle % totalColumns];
            if (middleElementValue == target) {
                return true;
            } else if (middleElementValue < target) {
                // go right
                left = middle + 1;
            } else {
                // go left
                right = middle - 1;
            }
        }
        // left > right, we can't find it
        return false;
    }
}