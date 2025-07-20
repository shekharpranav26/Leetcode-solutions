# Title: Delete Duplicate Folders in System
# Submission ID: 1705252360
# Status: Accepted
# Date: July 21, 2025 at 03:33:14 AM GMT+5:30

import java.util.*;

class Solution {
    static class Node {
        Map<String, Node> children = new HashMap<>();
        String serial = "";
    }

    Map<String, List<Node>> serialMap = new HashMap<>();
    Set<Node> duplicates = new HashSet<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node();

        // Step 1: Build the folder tree
        for (List<String> path : paths) {
            Node curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new Node());
                curr = curr.children.get(folder);
            }
        }

        // Step 2: Serialize all nodes
        serialize(root);

        // Step 3: Collect remaining paths
        List<List<String>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(Node node) {
        if (node.children.isEmpty()) return "";

        List<String> parts = new ArrayList<>();
        for (String name : new TreeSet<>(node.children.keySet())) {
            String childSerial = serialize(node.children.get(name));
            parts.add(name + "(" + childSerial + ")");
        }

        node.serial = String.join("", parts);
        serialMap.computeIfAbsent(node.serial, k -> new ArrayList<>()).add(node);

        if (serialMap.get(node.serial).size() > 1) {
            duplicates.addAll(serialMap.get(node.serial));
        }

        return node.serial;
    }

    private void dfs(Node node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            String name = entry.getKey();
            Node child = entry.getValue();
            if (!duplicates.contains(child)) {
                path.add(name);
                result.add(new ArrayList<>(path));
                dfs(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
