# Title: Soup Servings
# Submission ID: 1728280006
# Status: Accepted
# Date: August 9, 2025 at 12:01:34 AM GMT+5:30

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        if (n == 0) return 0.5;
        int units = (n + 24) / 25;      // convert mL -> 25mL units
        if (units >= 200) return 1.0;   // shortcut: converges to 1 for large n
        return dfs(units, units);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        double prob = 0.25 * (
            dfs(a - 4, b) +
            dfs(a - 3, b - 1) +
            dfs(a - 2, b - 2) +
            dfs(a - 1, b - 3)
        );

        memo.put(key, prob);
        return prob;
    }
}
