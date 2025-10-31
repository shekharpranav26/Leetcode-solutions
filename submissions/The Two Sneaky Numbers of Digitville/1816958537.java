# Title: The Two Sneaky Numbers of Digitville
# Submission ID: 1816958537
# Status: Accepted
# Date: October 31, 2025 at 09:09:24 PM GMT+5:30

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        boolean[] a = new boolean[n];
        int[] ar = new int[2];
        int k = 0;
        for(int i = 0;i<n;i++){
            if(a[nums[i]]==true) ar[k++] = nums[i];
            else a[nums[i]] = true;
        }
        return ar;
    }
}