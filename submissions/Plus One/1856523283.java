# Title: Plus One
# Submission ID: 1856523283
# Status: Accepted
# Date: December 15, 2025 at 11:45:31 PM GMT+5:30

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;        
    }
}