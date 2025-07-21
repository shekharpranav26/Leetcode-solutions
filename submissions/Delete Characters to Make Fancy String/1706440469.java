# Title: Delete Characters to Make Fancy String
# Submission ID: 1706440469
# Status: Accepted
# Date: July 22, 2025 at 01:29:54 AM GMT+5:30

class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        result.append(s.charAt(0)); // Always add the first character

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count < 3) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
