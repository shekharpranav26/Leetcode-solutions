# Title: Find the Index of the First Occurrence in a String
# Submission ID: 1853954321
# Status: Accepted
# Date: December 12, 2025 at 11:27:52 PM GMT+5:30

class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}