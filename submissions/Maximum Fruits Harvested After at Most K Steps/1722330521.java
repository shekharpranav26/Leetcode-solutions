# Title: Maximum Fruits Harvested After at Most K Steps
# Submission ID: 1722330521
# Status: Accepted
# Date: August 4, 2025 at 01:37:10 AM GMT+5:30

import java.util.*;

public class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0, total = 0;

        // Rightmost position we can reach
        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            // Shrink the window from the left if out of k-step reach
            while (left <= right && !canReach(fruits, left, right, startPos, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }

    // Check if it's possible to visit positions from left to right within k steps
    private boolean canReach(int[][] fruits, int left, int right, int startPos, int k) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        // Go left first then right
        int option1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        // Go right first then left
        int option2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(option1, option2) <= k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxTotalFruits(new int[][]{{2,8},{6,3},{8,6}}, 5, 4)); // 9
        System.out.println(sol.maxTotalFruits(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4)); // 14
        System.out.println(sol.maxTotalFruits(new int[][]{{0,3},{6,4},{8,5}}, 3, 2)); // 0
    }
}
