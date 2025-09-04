# Title: Find Closest Person
# Submission ID: 1759430363
# Status: Accepted
# Date: September 4, 2025 at 07:39:19 PM GMT+5:30

class Solution {

    public int findClosest(int x, int y, int z) {
        int dxz = Math.abs(x - z);
        int dyz = Math.abs(y - z);
        if (dxz < dyz) {
            return 1;
        } else if (dxz > dyz) {
            return 2;
        } else {
            return 0;
        }
    }
}