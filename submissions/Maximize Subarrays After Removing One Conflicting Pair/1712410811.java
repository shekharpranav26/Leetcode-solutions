# Title: Maximize Subarrays After Removing One Conflicting Pair
# Submission ID: 1712410811
# Status: Internal Error
# Date: July 26, 2025 at 10:56:01 PM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSubarrays(int n, int[][] conflictingPairs) {
        long totalSubarrays = (long) n * (n + 1) / 2;
        int maxValid = 0;

        for (int skip = 0; skip < conflictingPairs.length; skip++) {
            // Build conflict map with one pair removed
            Map<Integer, Set<Integer>> conflictMap = new HashMap<>();
            for (int i = 0; i < conflictingPairs.length; i++) {
                if (i == skip) continue;
                int a = conflictingPairs[i][0];
                int b = conflictingPairs[i][1];
                conflictMap.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                conflictMap.computeIfAbsent(b, k -> new HashSet<>()).add(a);
            }

            // Sliding window with two pointers
            int[] count = new int[n + 1];
            int left = 1;
            long valid = 0;
            Set<String> activeConflicts = new HashSet<>();

            for (int right = 1; right <= n; right++) {
                count[right]++;
                if (conflictMap.containsKey(right)) {
                    for (int b : conflictMap.get(right)) {
                        if (count[b] > 0) {
                            int x = Math.min(right, b);
                            int y = Math.max(right, b);
                            activeConflicts.add(x + "," + y);
                        }
                    }
                }

                while (!activeConflicts.isEmpty()) {
                    int lVal = left;
                    for (int b : conflictMap.getOrDefault(lVal, Collections.emptySet())) {
                        if (count[b] > 0) {
                            int x = Math.min(lVal, b);
                            int y = Math.max(lVal, b);
                            activeConflicts.remove(x + "," + y);
                        }
                    }
                    count[lVal]--;
                    left++;
                }

                valid += (right - left + 1);
            }

            maxValid = (int) Math.max(maxValid, valid);
        }

        return maxValid;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input1 = {{2, 3}, {1, 4}};
        System.out.println(sol.maxSubarrays(4, input1)); // 9

        int[][] input2 = {{1, 2}, {2, 5}, {3, 5}};
        System.out.println(sol.maxSubarrays(5, input2)); // 12
    }
}
