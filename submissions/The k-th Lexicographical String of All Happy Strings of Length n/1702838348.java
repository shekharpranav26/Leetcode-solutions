# Title: The k-th Lexicographical String of All Happy Strings of Length n
# Submission ID: 1702838348
# Status: Accepted
# Date: July 19, 2025 at 01:38:26 AM GMT+5:30

import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();

    public String getHappyString(int n, int k) {
        backtrack(n, "", ' ');
        if (k > result.size()) return "";
        return result.get(k - 1);
    }

    private void backtrack(int n, String current, char prev) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (ch != prev) {
                backtrack(n, current + ch, ch);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getHappyString(1, 3));
        System.out.println(sol.getHappyString(1, 4));
        System.out.println(sol.getHappyString(3, 9));
    }
}
