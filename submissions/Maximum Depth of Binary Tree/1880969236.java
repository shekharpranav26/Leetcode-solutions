# Title: Maximum Depth of Binary Tree
# Submission ID: 1880969236
# Status: Accepted
# Date: January 10, 2026 at 11:10:20 PM GMT+5:30

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left); // left height
        int rh = maxDepth(root.right); // right height

        return Math.max(lh, rh) + 1;
    }
}