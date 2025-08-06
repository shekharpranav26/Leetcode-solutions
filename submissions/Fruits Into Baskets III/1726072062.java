# Title: Fruits Into Baskets III
# Submission ID: 1726072062
# Status: Time Limit Exceeded
# Date: August 7, 2025 at 12:04:37 AM GMT+5:30

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];  // To track used baskets
        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;  // Mark basket as used
                    placed = true;
                    break;
                }
            }
            if (!placed) unplaced++;
        }

        return unplaced;
    }
}
