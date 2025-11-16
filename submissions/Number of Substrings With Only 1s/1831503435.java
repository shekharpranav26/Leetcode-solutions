# Title: Number of Substrings With Only 1s
# Submission ID: 1831503435
# Status: Accepted
# Date: November 16, 2025 at 10:02:31 PM GMT+5:30

class Solution {

    public int numSub(String s) {
        final int MODULO = 1000000007;
        long total = 0;
        int length = s.length();
        long consecutive = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                total += (consecutive * (consecutive + 1)) / 2;
                total %= MODULO;
                consecutive = 0;
            } else {
                consecutive++;
            }
        }
        total += (consecutive * (consecutive + 1)) / 2;
        total %= MODULO;
        return (int) total;
    }
}