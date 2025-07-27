# Title: Count Hills and Valleys in an Array
# Submission ID: 1713773072
# Status: Accepted
# Date: July 28, 2025 at 12:40:53 AM GMT+5:30

import java.util.*;

public class Solution {

    public int countHillValley(int[] nums) {
        // Step 1: Remove consecutive duplicates
        List<Integer> filtered = new ArrayList<>();
        filtered.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                filtered.add(nums[i]);
            }
        }

        // Step 2: Count hills and valleys
        int count = 0;
        for (int i = 1; i < filtered.size() - 1; i++) {
            int prev = filtered.get(i - 1);
            int curr = filtered.get(i);
            int next = filtered.get(i + 1);

            if (curr > prev && curr > next) {
                count++; // hill
            } else if (curr < prev && curr < next) {
                count++; // valley
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 4, 1, 1, 6, 5};
        int[] nums2 = {6, 6, 5, 5, 4, 1};

        System.out.println("Hills and Valleys in nums1: " + sol.countHillValley(nums1)); // Output: 3
        System.out.println("Hills and Valleys in nums2: " + sol.countHillValley(nums2)); // Output: 0
    }
}
