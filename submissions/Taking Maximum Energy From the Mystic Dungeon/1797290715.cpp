# Title: Taking Maximum Energy From the Mystic Dungeon
# Submission ID: 1797290715
# Status: Accepted
# Date: October 10, 2025 at 05:28:21 PM GMT+5:30

class Solution {
public:
    int maximumEnergy(vector<int>& energy, int k) {
        int n = energy.size(), ans = INT_MIN;
        for (int i = n - k; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j -= k) {
                sum += energy[j];
                ans = max(ans, sum);
            }
        }
        return ans;
    }
};