# Title: Minimum Score After Removals on a Tree
# Submission ID: 1709963880
# Status: Accepted
# Date: July 24, 2025 at 10:13:11 PM GMT+5:30

import java.util.*;

public class Solution {
    int[] nums;
    List<Integer>[] tree;
    int[] subtreeXor;
    int totalXor;
    int[] parent;

    public int minimumScore(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        subtreeXor = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        dfs(0, -1);

        int minScore = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor1, xor2, xor3;

                if (isAncestor(i, j)) {
                    xor1 = subtreeXor[j];
                    xor2 = subtreeXor[i] ^ xor1;
                    xor3 = totalXor ^ subtreeXor[i];
                } else if (isAncestor(j, i)) {
                    xor1 = subtreeXor[i];
                    xor2 = subtreeXor[j] ^ xor1;
                    xor3 = totalXor ^ subtreeXor[j];
                } else {
                    xor1 = subtreeXor[i];
                    xor2 = subtreeXor[j];
                    xor3 = totalXor ^ xor1 ^ xor2;
                }

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, max - min);
            }
        }

        return minScore;
    }

    private int dfs(int node, int par) {
        int xor = nums[node];
        for (int nei : tree[node]) {
            if (nei == par) continue;
            parent[nei] = node;
            xor ^= dfs(nei, node);
        }
        subtreeXor[node] = xor;
        totalXor = subtreeXor[0]; 
        return xor;
    }

    private boolean isAncestor(int u, int v) {
        while (v != -1) {
            if (v == u) return true;
            v = parent[v];
        }
        return false;
    }
}
