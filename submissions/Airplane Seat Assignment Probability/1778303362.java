# Title: Airplane Seat Assignment Probability
# Submission ID: 1778303362
# Status: Accepted
# Date: September 21, 2025 at 10:56:45 PM GMT+5:30

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1)
            return 1;
        else
            return 0.5;
    }
}