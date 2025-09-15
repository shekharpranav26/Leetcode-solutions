# Title: Maximum Number of Words You Can Type
# Submission ID: 1771475663
# Status: Accepted
# Date: September 15, 2025 at 04:16:28 PM GMT+5:30

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Convert broken letters into a set for quick lookup
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        int count = 0;
        String[] words = text.split(" ");

        for (String word : words) {
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (broken[c - 'a']) {  // if word contains a broken letter
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }
        return count;
    }
}
