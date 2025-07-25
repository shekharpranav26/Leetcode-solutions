# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711504972
# Status: Wrong Answer
# Date: July 26, 2025 at 02:36:57 AM GMT+5:30

class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        
        // Try all possible subsequences using bitmask
        for (int mask = 1; mask < (1 << n); mask++) {
            // Build subsequence based on mask
            java.util.List<Integer> subseqList = new java.util.ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subseqList.add(nums[i]);
                }
            }
            
            // Convert to array
            int[] subseq = new int[subseqList.size()];
            for (int i = 0; i < subseqList.size(); i++) {
                subseq[i] = subseqList.get(i);
            }
            
            // Find maximum sum subarray with unique elements in this subsequence
            maxSum = Math.max(maxSum, maxUniqueSubarraySum(subseq));
        }
        
        return maxSum;
    }
    
    private int maxUniqueSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        
        // Try all possible subarrays
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[201]; // -100 to 100 mapped to 0 to 200
            int sum = 0;
            
            for (int j = i; j < n; j++) {
                int val = arr[j] + 100; // Map to 0-200 range
                
                if (seen[val]) {
                    // Duplicate found, stop extending this subarray
                    break;
                }
                
                seen[val] = true;
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
}