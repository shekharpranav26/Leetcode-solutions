# Title: Reordered Power of 2
# Submission ID: 1730441370
# Status: Accepted
# Date: August 10, 2025 at 11:43:11 PM GMT+5:30

import java.util.*;

public class Solution {
    public boolean reorderedPowerOf2(int n) {
        // Get the sorted string representation of n
        String target = countDigits(n);

        // Check against all powers of two up to 2^30
        for (int i = 0; i < 31; i++) {
            if (target.equals(countDigits(1 << i))) {
                return true;
            }
        }
        return false;
    }

    // Convert number into a sorted string of its digits
    private String countDigits(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reorderedPowerOf2(1));   // true
        System.out.println(sol.reorderedPowerOf2(10));  // false
        System.out.println(sol.reorderedPowerOf2(46));  // true (since 46 can be reordered to 64)
    }
}
