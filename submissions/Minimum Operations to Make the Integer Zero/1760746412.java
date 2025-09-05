# Title: Minimum Operations to Make the Integer Zero
# Submission ID: 1760746412
# Status: Accepted
# Date: September 5, 2025 at 11:20:06 PM GMT+5:30

class Solution {

    public int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while (true) {
            long x = num1 - (long) num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
            k++;
        }
    }
}