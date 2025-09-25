# Title: Triangle
# Submission ID: 1782466238
# Status: Accepted
# Date: September 25, 2025 at 09:39:49 PM GMT+5:30

class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        for (int i = tri.size() - 2; i >= 0; i--)
            for (int j = 0; j < tri.get(i).size(); j++)
                tri.get(i).set(j, tri.get(i).get(j) + Math.min(
                    tri.get(i + 1).get(j),
                    tri.get(i + 1).get(j + 1)
                ));
        return tri.get(0).get(0);
    }
}