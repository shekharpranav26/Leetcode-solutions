# Title: Remove Element
# Submission ID: 1853171952
# Status: Accepted
# Date: December 12, 2025 at 12:01:24 AM GMT+5:30

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;        
    }
}