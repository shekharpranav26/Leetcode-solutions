# Title: Maximum Number of Operations to Move Ones to the End
# Submission ID: 1828903768
# Status: Accepted
# Date: November 13, 2025 at 10:13:31 PM GMT+5:30

class Solution {
    public int maxOperations(String s) {
        int ones = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                ones++;
            else if (i > 0 && s.charAt(i - 1) == '1')
                res += ones;
        }
        return res;
    }
}