# Title: Maximize Subarrays After Removing One Conflicting Pair
# Submission ID: 1712423621
# Status: Internal Error
# Date: July 26, 2025 at 11:06:32 PM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSubarrays(int n, int[][] conflictingPairs) {
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
            boolean[] present = new boolean[n + 1];
            int left = 1;
            int valid = 0;
            Set<String> activeConflicts = new HashSet<>();

            for (int right = 1; right <= n; right++) {
                present[right] = true;
                
                // Add new conflicts involving right
                if (conflictMap.containsKey(right)) {
                    for (int b : conflictMap.get(right)) {
                        if (present[b]) {
                            int x = Math.min(right, b);
                            int y = Math.max(right, b);
                            activeConflicts.add(x + "," + y);
                        }
                    }
                }

                // Shrink window while there are conflicts
                while (!activeConflicts.isEmpty()) {
                    // Remove conflicts involving left
                    if (conflictMap.containsKey(left)) {
                        for (int b : conflictMap.get(left)) {
                            if (present[b]) {
                                int x = Math.min(left, b);
                                int y = Math.max(left, b);
                                activeConflicts.remove(x + "," + y);
                            }
                        }
                    }
                    present[left] = false;
                    left++;
                }

                // All subarrays ending at right and starting from left to right are valid
                valid += (right - left + 1);
            }

            maxValid = Math.max(maxValid, valid);
        }

        return maxValid;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] input1 = {{2, 3}, {1, 4}};
        System.out.println(sol.maxSubarrays(4, input1)); // Expected: 9
        
        int[][] input2 = {{1, 2}, {2, 5}, {3, 5}};
        System.out.println(sol.maxSubarrays(5, input2)); // Expected: 12
    }
}