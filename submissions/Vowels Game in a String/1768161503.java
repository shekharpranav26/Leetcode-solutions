# Title: Vowels Game in a String
# Submission ID: 1768161503
# Status: Accepted
# Date: September 12, 2025 at 04:12:00 PM GMT+5:30

class Solution {

    public boolean doesAliceWin(String s) {
        return s
            .chars()
            .anyMatch(c -> {
                return "aeiou".indexOf(c) != -1;
            });
    }
}