# Title: Is Subsequence
# Submission ID: 1790204790
# Status: Accepted
# Date: October 3, 2025 at 07:33:28 PM GMT+5:30

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        int p = 0; //Pointer for subsequence
        for(int i=0;i<tL;i++){
            if(p<sL && s.charAt(p)==t.charAt(i)) p++; 
            /*Ts makes sure pointer never goes outOfIndex
            and counts the same characters*/
        }
        return p == sL; //This just checks if we found all chars
    }
}