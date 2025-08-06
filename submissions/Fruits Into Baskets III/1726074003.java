# Title: Fruits Into Baskets III
# Submission ID: 1726074003
# Status: Internal Error
# Date: August 7, 2025 at 12:06:15 AM GMT+5:30

import java.util.*;

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        // Each basket needs to know its index and capacity
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < n; i++) available.add(i);

        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j : available) {
                if (baskets[j] >= fruits[i]) {
                    available.remove(j);  // Mark basket as used
                    placed = true;
                    break;
                }
            }
            if (!placed) unplaced++;
        }

        return unplaced;
    }
}
