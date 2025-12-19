# Title: Merge Sorted Array
# Submission ID: 1860012349
# Status: Accepted
# Date: December 19, 2025 at 11:29:18 PM GMT+5:30

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}
