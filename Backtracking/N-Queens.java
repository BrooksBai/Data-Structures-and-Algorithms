/*
  LeetCode 51. N-Queens: https://leetcode.com/problems/n-queens/
  Time: tricky, super-exponential(lower bound)
  Space: O(n) (call stack)
*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void solveNQueens(int n, int row, List<Integer> colPlacements, List<List<String>> result) {
        // All n queens have been placed in the n rows.
        if (row == n) {
            result.add(generateBoardFromPlacements(colPlacements, n));
        } else {
            /*
              Try all columns in the current row that we are making a choice on.
              The colPlacements list will hold the column we place the queen for the i'th row.
              So if I have [1, 3, 0, 2] that means:
              It is a 4 x 4 board.
              row 0 has a queen placed in column 1
              row 1 has a queen placed in column 3
              row 2 has a queen placed in column 0
              row 3 has a queen placed in column 2
            */
            for (int col = 0; col < n; col++) {
                // choose
                colPlacements.add(col);
                // explore
                if (isValid(colPlacements)) {
                    solveNQueens(n, row + 1, colPlacements, result);
                }
                // unchoose  
                colPlacements.remove(colPlacements.size() - 1);
            }
        }
    }
    
    private static boolean isValid(List<Integer> colPlacements) {
        int rowId = colPlacements.size() - 1;
        // Is this placement against every previous row's placement?
        for (int i = 0; i < rowId; i++) {
            int absColDist = Math.abs(colPlacements.get(i) - colPlacements.get(rowId));
            if (absColDist == 0 || absColDist == rowId - i) {
                return false;
            }
        }
        return true;
    }
    
    /* Generate a board from the list of column placements for each of the n rows. */
    private List<String> generateBoardFromPlacements(List<Integer> colPlacements, int n) {
        List<String> board = new ArrayList<>();
        // Materialze a row for each queen that we placed
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                /* Go through all columns in the row and populate the string.
                   If the column has a queen in it, place a 'Q', otherwise place a '.'
                */
                if (col == colPlacements.get(row)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            // Add the row to the board
            board.add(sb.toString());
        }
        return board;
    }
}