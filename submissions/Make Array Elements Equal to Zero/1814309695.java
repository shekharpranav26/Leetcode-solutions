# Title: Make Array Elements Equal to Zero
# Submission ID: 1814309695
# Status: Accepted
# Date: October 28, 2025 at 11:17:05 PM GMT+5:30

class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0, ls = 0, cases = 0;
        for (int num : nums) total += num;

        for (int num : nums) {
            int rs = total - ls - num;
            if (num == 0) {
                if (ls == rs) {
                    cases += 2;
                } else if (ls == rs - 1 || ls - 1 == rs) {
                    cases += 1;
                }
            }
            ls += num;
        }
        return cases;
    }
}