# Title: Maximize Subarrays After Removing One Conflicting Pair
# Submission ID: 1712421032
# Status: Internal Error
# Date: July 26, 2025 at 11:04:24 PM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSubarrays(int n, int[][] conflictingPairs) {
        int maxValid = 0;
        
        // Try removing each conflicting pair
        for (int skip = 0; skip < conflictingPairs.length; skip++) {
            // Build remaining conflicts after removing one pair
            List<int[]> conflicts = new ArrayList<>();
            for (int i = 0; i < conflictingPairs.length; i++) {
                if (i != skip) {
                    conflicts.add(conflictingPairs[i]);
                }
            }
            
            // Calculate valid subarrays using optimized approach
            int validCount = countValidSubarrays(n, conflicts);
            maxValid = Math.max(maxValid, validCount);
        }
        
        return maxValid;
    }
    
    private int countValidSubarrays(int n, List<int[]> conflicts) {
        int validCount = 0;
        
        // For each possible left boundary
        for (int left = 1; left <= n; left++) {
            boolean[] present = new boolean[n + 1];
            
            // Extend right boundary as far as possible
            for (int right = left; right <= n; right++) {
                present[right] = true;
                
                // Check if current window violates any conflict
                boolean hasConflict = false;
                for (int[] conflict : conflicts) {
                    if (present[conflict[0]] && present[conflict[1]]) {
                        hasConflict = true;
                        break;
                    }
                }
                
                if (hasConflict) {
                    break;
                }
                
                // Current subarray [left, right] is valid
                validCount++;
            }
        }
        
        return validCount;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] input1 = {{2, 3}, {1, 4}};
        System.out.println(sol.maxSubarrays(4, input1)); // Expected: 9
        
        int[][] input2 = {{1, 2}, {2, 5}, {3, 5}};
        System.out.println(sol.maxSubarrays(5, input2)); // Expected: 12
    }
}