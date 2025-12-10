# Title: Remove Duplicates from Sorted Array
# Submission ID: 1852199322
# Status: Accepted
# Date: December 10, 2025 at 10:16:06 PM GMT+5:30

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;        
    }
}