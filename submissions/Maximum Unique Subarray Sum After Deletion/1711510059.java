# Title: Maximum Unique Subarray Sum After Deletion
# Submission ID: 1711510059
# Status: Accepted
# Date: July 26, 2025 at 02:47:04 AM GMT+5:30

class Solution {

    public int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumsSet.add(num);
            }
        }
        if (positiveNumsSet.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return positiveNumsSet.stream().mapToInt(Integer::intValue).sum();
    }
}