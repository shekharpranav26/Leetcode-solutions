# Title: Maximum 69 Number
# Submission ID: 1737594494
# Status: Accepted
# Date: August 16, 2025 at 10:12:33 PM GMT+5:30

class Solution {
    public int maximum69Number (int num) {
        // Convert number to string
        char[] digits = String.valueOf(num).toCharArray();

        // Change the first '6' to '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // only one change allowed
            }
        }

        // Convert back to integer
        return Integer.parseInt(new String(digits));
    }
}
