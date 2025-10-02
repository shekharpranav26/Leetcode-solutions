# Title: Water Bottles II
# Submission ID: 1789187676
# Status: Accepted
# Date: October 2, 2025 at 06:10:50 PM GMT+5:30

class Solution {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        for (int empty = numBottles; empty >= numExchange; numExchange++) {
            ans++;
            empty -= numExchange - 1;
        }
        return ans;
    }
}