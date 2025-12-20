# Title: Binary Tree Inorder Traversal
# Submission ID: 1860886438
# Status: Accepted
# Date: December 20, 2025 at 11:13:03 PM GMT+5:30

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorder(root, res);
        return res;        
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }    
}