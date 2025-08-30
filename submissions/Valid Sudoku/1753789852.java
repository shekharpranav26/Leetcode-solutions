# Title: Valid Sudoku
# Submission ID: 1753789852
# Status: Accepted
# Date: August 30, 2025 at 09:58:20 PM GMT+5:30

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // use sets to keep track of seen numbers
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // build unique keys for row, col, and box
                    String rowKey = num + " in row " + i;
                    String colKey = num + " in col " + j;
                    String boxKey = num + " in box " + (i / 3) + "-" + (j / 3);

                    // check duplicates
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
