# Title: Apply Operations to an Array
# Submission ID: 1714781394
# Status: Accepted
# Date: July 28, 2025 at 10:00:03 PM GMT+5:30

import java.util.*;

public class Solution {

    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Perform the operations sequentially
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Shift all non-zero elements to the front
        int[] result = new int[n];
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        return result;
    }

    // Main method to test with sample inputs
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 2, 1, 1, 0};
        System.out.println("Output 1: " + Arrays.toString(sol.applyOperations(nums1))); // [1, 4, 2, 0, 0, 0]

        int[] nums2 = {0, 1};
        System.out.println("Output 2: " + Arrays.toString(sol.applyOperations(nums2))); // [1, 0]

        int[] nums3 = {2, 2, 2, 2};
        System.out.println("Output 3: " + Arrays.toString(sol.applyOperations(nums3))); // [4, 4, 0, 0]
    }
}
