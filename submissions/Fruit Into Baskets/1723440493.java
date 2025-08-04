# Title: Fruit Into Baskets
# Submission ID: 1723440493
# Status: Accepted
# Date: August 4, 2025 at 11:26:02 PM GMT+5:30

import java.util.*;

public class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] test1 = {1, 2, 1};
        int[] test2 = {0, 1, 2, 2};
        int[] test3 = {1, 2, 3, 2, 2};
        int[] test4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        System.out.println("Test 1 Output: " + obj.totalFruit(test1)); // 3
        System.out.println("Test 2 Output: " + obj.totalFruit(test2)); // 3
        System.out.println("Test 3 Output: " + obj.totalFruit(test3)); // 4
        System.out.println("Test 4 Output: " + obj.totalFruit(test4)); // 5
    }
}
