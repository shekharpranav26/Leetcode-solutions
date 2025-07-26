# Title: Maximize Subarrays After Removing One Conflicting Pair
# Submission ID: 1712409361
# Status: Internal Error
# Date: July 26, 2025 at 10:54:47 PM GMT+5:30

import java.util.*;

public class Solution {
    public int maxSubarrays(int n, int[][] conflictingPairs) {
        long total = (long) n * (n + 1) / 2;
        int maxValid = 0;

        // Build conflict map
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] pair : conflictingPairs) {
            int a = pair[0];
            int b = pair[1];
            graph[a].add(new int[]{a, b});
            graph[b].add(new int[]{b, a});
        }

        for (int removeIdx = 0; removeIdx < conflictingPairs.length; removeIdx++) {
            boolean[] blocked = new boolean[n + 1];
            int[][] tempPairs = new int[conflictingPairs.length - 1][2];
            int idx = 0;
            for (int i = 0; i < conflictingPairs.length; i++) {
                if (i == removeIdx) continue;
                tempPairs[idx++] = conflictingPairs[i];
            }

            Map<Integer, List<Integer>> conflictMap = new HashMap<>();
            for (int[] pair : tempPairs) {
                conflictMap.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
                conflictMap.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
            }

            int left = 0;
            long valid = 0;
            Set<Integer> set = new HashSet<>();

            for (int right = 1; right <= n; right++) {
                set.add(right);
                while (hasConflict(set, conflictMap)) {
                    left++;
                    set.remove(left);
                }
                valid += right - left;
            }

            maxValid = (int) Math.max(maxValid, valid);
        }

        return maxValid;
    }

    private boolean hasConflict(Set<Integer> set, Map<Integer, List<Integer>> map) {
        for (int x : set) {
            if (!map.containsKey(x)) continue;
            for (int y : map.get(x)) {
                if (set.contains(y)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // You can plug in your big test case here for validation
        Solution sol = new Solution();
        int[][] input = {{2, 3}, {1, 4}};
        System.out.println(sol.maxSubarrays(4, input)); // Expected: 9
    }
}
