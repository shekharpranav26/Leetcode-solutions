# Title: Longest Substring Without Repeating Characters
# Submission ID: 1714986946
# Status: Accepted
# Date: July 29, 2025 at 12:34:16 AM GMT+5:30

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0, right = 0;

        HashSet<Character> seen = new HashSet<>();

        while (right < n) {
            char c = s.charAt(right);
            if (!seen.contains(c)) {
                seen.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    // Sample test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // 3
    }
}
