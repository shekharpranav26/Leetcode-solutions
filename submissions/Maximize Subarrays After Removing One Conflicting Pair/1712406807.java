# Title: Maximize Subarrays After Removing One Conflicting Pair
# Submission ID: 1712406807
# Status: Internal Error
# Date: July 26, 2025 at 10:52:41 PM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSubarrays(int n, int[][] conflictingPairs) {
        long total = (long) n * (n + 1) / 2;
        int maxValid = 0;

        for (int i = 0; i < conflictingPairs.length; i++) {
            // Remove one conflicting pair
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int j = 0; j < conflictingPairs.length; j++) {
                if (i == j) continue;
                int a = conflictingPairs[j][0];
                int b = conflictingPairs[j][1];
                map.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                map.computeIfAbsent(b, k -> new HashSet<>()).add(a);
            }

            int left = 0;
            Map<Integer, Integer> freq = new HashMap<>();
            long validCount = 0;

            for (int right = 1; right <= n; right++) {
                int rVal = right;
                freq.put(rVal, freq.getOrDefault(rVal, 0) + 1);

                while (!isWindowValid(freq, map)) {
                    int lVal = ++left;
                    freq.put(lVal, freq.get(lVal) - 1);
                    if (freq.get(lVal) == 0) freq.remove(lVal);
                }

                validCount += right - left;
            }

            maxValid = (int) Math.max(maxValid, validCount);
        }

        return maxValid;
    }

    private boolean isWindowValid(Map<Integer, Integer> freq, Map<Integer, Set<Integer>> map) {
        for (int key : freq.keySet()) {
            if (map.containsKey(key)) {
                for (int other : map.get(key)) {
                    if (freq.containsKey(other)) return false;
                }
            }
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input1 = {{2, 3}, {1, 4}};
        System.out.println(sol.maxSubarrays(4, input1));  // Output: 9

        int[][] input2 = {{1, 2}, {2, 5}, {3, 5}};
        System.out.println(sol.maxSubarrays(5, input2));  // Output: 12
    }
}
