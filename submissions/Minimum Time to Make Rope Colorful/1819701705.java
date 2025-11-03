# Title: Minimum Time to Make Rope Colorful
# Submission ID: 1819701705
# Status: Accepted
# Date: November 3, 2025 at 09:24:47 PM GMT+5:30

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length(), sum = 0;
        for (int i = 1; i < n; i++) {
            int maxi = 0;
            while (i < n && colors.charAt(i) == colors.charAt(i - 1)) {
                sum += neededTime[i - 1];
                maxi = Math.max(maxi, neededTime[i - 1]);
                i++;
            }
            sum += neededTime[i - 1];
            maxi = Math.max(maxi, neededTime[i - 1]);
            if (maxi != 0) sum -= maxi;
        }
        return sum;
    }
}