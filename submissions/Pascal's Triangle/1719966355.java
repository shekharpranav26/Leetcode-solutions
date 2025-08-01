# Title: Pascal's Triangle
# Submission ID: 1719966355
# Status: Accepted
# Date: August 2, 2025 at 01:50:23 AM GMT+5:30

import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // first element is always 1

            // Fill the row with the sum of the two numbers above
            for (int j = 1; j < i; j++) {
                int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(val);
            }

            if (i > 0) row.add(1); // last element is also 1 if row has more than one element

            triangle.add(row);
        }

        return triangle;
    }

    // Sample usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generate(5));  // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.println(sol.generate(1));  // [[1]]
    }
}
