# Title: Remove Sub-Folders from the Filesystem
# Submission ID: 1703417735
# Status: Accepted
# Date: July 19, 2025 at 05:04:04 PM GMT+5:30

import java.util.*;

public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String prev = "";

        for (String path : folder) {
            if (prev.isEmpty() || !path.startsWith(prev + "/")) {
                result.add(path);
                prev = path;
            }
        }

        return result;
    }

    // Optional main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
        // Output: ["/a", "/c/d", "/c/f"]

        System.out.println(sol.removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}));
        // Output: ["/a"]

        System.out.println(sol.removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
        // Output: ["/a/b/c", "/a/b/ca", "/a/b/d"]
    }
}
