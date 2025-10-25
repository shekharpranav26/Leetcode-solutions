# Title: Calculate Money in Leetcode Bank
# Submission ID: 1811457663
# Status: Accepted
# Date: October 25, 2025 at 10:48:47 PM GMT+5:30

class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int monday = 1;
        
        while (n > 0) {
            for (int day = 0; day < Math.min(n, 7); day++) {
                ans += monday + day;
            }
            
            n -= 7;
            monday++;
        }
        
        return ans;
    }
}