# Title: Roman to Integer
# Submission ID: 1845207304
# Status: Accepted
# Date: December 2, 2025 at 10:19:11 PM GMT+5:30

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;

            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
}
