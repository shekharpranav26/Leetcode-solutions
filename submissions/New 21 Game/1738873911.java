# Title: New 21 Game
# Submission ID: 1738873911
# Status: Time Limit Exceeded
# Date: August 18, 2025 at 12:01:23 AM GMT+5:30

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double dp[] = new double[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxPts; j++) {
                if (i - j >= 0 && i - j < k) {
                    dp[i] += dp[i - j] / maxPts;
                }
            }
        }
        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }
}