# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711499860
# Status: Wrong Answer
# Date: July 26, 2025 at 02:27:20 AM GMT+5:30

import java.util.HashSet;

public class Solution {
    
    public int maxSum(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int maxSum = 0;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // If the element is already seen, move the left pointer
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            // Add the current element to the set and the current sum
            seen.add(nums[right]);
            currentSum += nums[right];
            // Update the maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    
    // Test method
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Test 1: " + solution.maxSum(nums1)); // Expected: 15
        
        // Test case 2
        int[] nums2 = {1, 1, 0, 1, 1};
        System.out.println("Test 2: " + solution.maxSum(nums2)); // Expected: 1
        
        // Test case 3
        int[] nums3 = {1, 2, -1, -2, 1, 0, -1};
        System.out.println("Test 3: " + solution.maxSum(nums3)); // Expected: 3
        
        // Additional test cases
        int[] nums4 = {-1, -2, -3};
        System.out.println("Test 4: " + solution.maxSum(nums4)); // Expected: -1
        
        int[] nums5 = {5, 5, 5, 5};
        System.out.println("Test 5: " + solution.maxSum(nums5)); // Expected: 5
    }
}
