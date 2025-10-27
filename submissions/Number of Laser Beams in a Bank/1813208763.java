# Title: Number of Laser Beams in a Bank
# Submission ID: 1813208763
# Status: Accepted
# Date: October 27, 2025 at 07:47:47 PM GMT+5:30

class Solution {
  public int numberOfBeams(String[] bank) {
    int prev = 0, ans = 0;

    for (String s: bank) {
      int count = 0;
      for (int i = 0; i < s.length(); i++)
        if (s.charAt(i) == '1') {
          count++;
        }

      if (count > 0) {
        ans += prev * count;
        prev = count;
      }
    }

    return ans;
  }
}