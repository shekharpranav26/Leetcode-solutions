# Title: Minimum Difference in Sums After Removal of Elements
# Submission ID: 1701850956
# Status: Accepted
# Date: July 18, 2025 at 05:34:03 AM GMT+5:30

import java.util.*;

public class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;
        
        long[] leftSum = new long[len];
        long[] rightSum = new long[len];
        
        // Minimize the left half sum using max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sumLeft = 0;
        for (int i = 0; i < 2 * n; i++) {
            sumLeft += nums[i];
            maxHeap.add(nums[i]);
            if (maxHeap.size() > n) {
                sumLeft -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                leftSum[i] = sumLeft;
            }
        }
        
        // Maximize the right half sum using min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumRight = 0;
        for (int i = len - 1; i >= n; i--) {
            sumRight += nums[i];
            minHeap.add(nums[i]);
            if (minHeap.size() > n) {
                sumRight -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                rightSum[i] = sumRight;
            }
        }
        
        // Find the minimum difference
        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (leftSum[i] != 0 && rightSum[i + 1] != 0) {
                res = Math.min(res, leftSum[i] - rightSum[i + 1]);
            }
        }
        
        return res;
    }

    // Sample test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumDifference(new int[]{3, 1, 2}));          // Output: -1
        System.out.println(sol.minimumDifference(new int[]{7, 9, 5, 8, 1, 3})); // Output: 1
    }
}
