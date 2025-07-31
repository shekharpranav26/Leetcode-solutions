# Title: Bitwise ORs of Subarrays
# Submission ID: 1718619485
# Status: Accepted
# Date: July 31, 2025 at 10:40:16 PM GMT+5:30

import java.util.*;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        Set<Integer> next = new HashSet<>();

        for (int num : arr) {
            next.clear();
            next.add(num);

            for (int prev : cur) {
                next.add(num | prev);
            }

            res.addAll(next);

            // Swap sets to reuse memory
            Set<Integer> temp = cur;
            cur = next;
            next = temp;
        }

        return res.size();
    }

    // Sample usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subarrayBitwiseORs(new int[]{0}));        // 1
        System.out.println(sol.subarrayBitwiseORs(new int[]{1,1,2}));    // 3
        System.out.println(sol.subarrayBitwiseORs(new int[]{1,2,4}));    // 6
    }
}
