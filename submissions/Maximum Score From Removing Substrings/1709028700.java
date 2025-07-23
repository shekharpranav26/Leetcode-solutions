# Title: Maximum Score From Removing Substrings
# Submission ID: 1709028700
# Status: Accepted
# Date: July 24, 2025 at 02:59:33 AM GMT+5:30

public class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removePattern(s, 'a', 'b', x, y);
        } else {
            return removePattern(s, 'b', 'a', y, x);
        }
    }

    private int removePattern(String s, char first, char second, int firstPoints, int secondPoints) {
        StringBuilder stack1 = new StringBuilder();
        int total = 0;

        for (char c : s.toCharArray()) {
            int len = stack1.length();
            if (len > 0 && stack1.charAt(len - 1) == first && c == second) {
                stack1.deleteCharAt(len - 1);
                total += firstPoints;
            } else {
                stack1.append(c);
            }
        }

        StringBuilder stack2 = new StringBuilder();
        for (int i = 0; i < stack1.length(); i++) {
            char c = stack1.charAt(i);
            int len = stack2.length();
            if (len > 0 && stack2.charAt(len - 1) == second && c == first) {
                stack2.deleteCharAt(len - 1);
                total += secondPoints;
            } else {
                stack2.append(c);
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumGain("cdbcbbaaabab", 4, 5));  // Output: 19
        System.out.println(sol.maximumGain("aabbaaxybbaabb", 5, 4)); // Output: 20
    }
}
