# Title: Find Most Frequent Vowel and Consonant
# Submission ID: 1769076427
# Status: Internal Error
# Date: September 13, 2025 at 02:20:28 PM GMT+5:30

class Solution {

    public int maxFreqSum(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        int vowel = 0;
        int consonant = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (isVowel(ch)) {
                vowel = Math.max(vowel, mp.getOrDefault(ch, 0));
            } else {
                consonant = Math.max(consonant, mp.getOrDefault(ch, 0));
            }
        }
        return vowel + consonant;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}