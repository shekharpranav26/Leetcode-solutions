# Title: Final Value of Variable After Performing Operations
# Submission ID: 1806716577
# Status: Accepted
# Date: October 20, 2025 at 06:05:30 PM GMT+5:30

class Solution {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if ("X++".equals(op) || "++X".equals(op)) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}