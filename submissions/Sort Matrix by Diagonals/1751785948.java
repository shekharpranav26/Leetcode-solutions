# Title: Sort Matrix by Diagonals
# Submission ID: 1751785948
# Status: Accepted
# Date: August 29, 2025 at 02:26:20 AM GMT+5:30

class Solution {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; i + j < n; j++) {
                tmp.add(grid[i + j][j]);
            }
            tmp.sort(Collections.reverseOrder());
            for (int j = 0; i + j < n; j++) {
                grid[i + j][j] = tmp.get(j);
            }
        }

        for (int j = 1; j < n; j++) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; j + i < n; i++) {
                tmp.add(grid[i][j + i]);
            }
            Collections.sort(tmp);
            for (int i = 0; j + i < n; i++) {
                grid[i][j + i] = tmp.get(i);
            }
        }

        return grid;
    }
}