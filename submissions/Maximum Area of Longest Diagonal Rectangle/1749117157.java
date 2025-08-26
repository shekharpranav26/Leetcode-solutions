# Title: Maximum Area of Longest Diagonal Rectangle
# Submission ID: 1749117157
# Status: Accepted
# Date: August 26, 2025 at 08:14:57 PM GMT+5:30

class Solution {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiaSq = 0;
        int maxArea = 0;
        for (int[] dim : dimensions) {
            int l = dim[0];
            int w = dim[1];
            int diaSq = l * l + w * w;
            int area = l * w;
            if (diaSq > maxDiaSq) {
                maxDiaSq = diaSq;
                maxArea = area;
            } else if (diaSq == maxDiaSq) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}