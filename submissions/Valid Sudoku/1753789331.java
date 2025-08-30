# Title: Valid Sudoku
# Submission ID: 1753789331
# Status: Accepted
# Date: August 30, 2025 at 09:57:52 PM GMT+5:30

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use hashsets to track seen numbers for rows, columns, and boxes
        HashSet<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Create unique keys for row, column, and box
                    String rowKey = num + " in row " + i;
                    String colKey = num + " in col " + j;
                    String boxKey = num + " in box " + (i / 3) + "-" + (j / 3);

                    // If already present, it's invalid
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
