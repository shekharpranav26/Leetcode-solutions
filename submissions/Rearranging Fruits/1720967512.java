# Title: Rearranging Fruits
# Submission ID: 1720967512
# Status: Accepted
# Date: August 2, 2025 at 10:28:01 PM GMT+5:30

import java.util.*;

public class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count all fruit occurrences
        for (int num : basket1) freq.put(num, freq.getOrDefault(num, 0) + 1);
        for (int num : basket2) freq.put(num, freq.getOrDefault(num, 0) - 1);

        // Check feasibility
        List<Integer> extras = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int diff = entry.getValue();
            if (diff % 2 != 0) return -1; // impossible

            for (int i = 0; i < Math.abs(diff) / 2; i++) {
                extras.add(entry.getKey());
            }
        }

        if (extras.isEmpty()) return 0;

        // Sort extras to pair smallest cost first
        Collections.sort(extras);

        // Minimum element from both baskets for "double swap trick"
        int minElement = Integer.MAX_VALUE;
        for (int num : basket1) minElement = Math.min(minElement, num);
        for (int num : basket2) minElement = Math.min(minElement, num);

        long cost = 0;
        int half = extras.size() / 2;

        for (int i = 0; i < half; i++) {
            cost += Math.min(extras.get(i), 2 * minElement);
        }

        return cost;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minCost(new int[]{4,2,2,2}, new int[]{1,4,1,2})); // Output: 1
        System.out.println(sol.minCost(new int[]{2,3,4,1}, new int[]{3,2,5,1})); // Output: -1
    }
}
