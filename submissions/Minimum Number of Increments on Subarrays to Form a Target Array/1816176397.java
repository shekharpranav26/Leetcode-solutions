# Title: Minimum Number of Increments on Subarrays to Form a Target Array
# Submission ID: 1816176397
# Status: Accepted
# Date: October 30, 2025 at 11:04:57 PM GMT+5:30

class Solution {
    public int minNumberOperations(int[] target) {
        int sum = target[0]; // start with first element
        for (int i = 1; i < target.length; i++) {
            // add increase only when current > previous
            if (target[i] > target[i - 1]) {
                sum += target[i] - target[i - 1];
            }
        }
        return sum; // total operations
    }
}