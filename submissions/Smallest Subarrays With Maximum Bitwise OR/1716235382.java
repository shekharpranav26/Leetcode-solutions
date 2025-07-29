# Title: Smallest Subarrays With Maximum Bitwise OR
# Submission ID: 1716235382
# Status: Accepted
# Date: July 30, 2025 at 12:06:52 AM GMT+5:30

import java.util.*;

public class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        Map<Integer, Integer> cur = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            Map<Integer, Integer> newMap = new HashMap<>();
            newMap.put(nums[i], 1);

            for (Map.Entry<Integer, Integer> entry : cur.entrySet()) {
                int newOr = nums[i] | entry.getKey();
                int newLen = entry.getValue() + 1;
                newMap.put(newOr, Math.min(newMap.getOrDefault(newOr, Integer.MAX_VALUE), newLen));
            }

            cur = newMap;

            int maxOr = 0, minLen = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : cur.entrySet()) {
                if (entry.getKey() > maxOr) {
                    maxOr = entry.getKey();
                    minLen = entry.getValue();
                } else if (entry.getKey() == maxOr) {
                    minLen = Math.min(minLen, entry.getValue());
                }
            }

            answer[i] = minLen;
        }

        return answer;
    }
}
