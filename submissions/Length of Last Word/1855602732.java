# Title: Length of Last Word
# Submission ID: 1855602732
# Status: Accepted
# Date: December 14, 2025 at 11:12:30 PM GMT+5:30

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length()-1;
        int count =0;
        for(int i=n;i>=0; i--){
            if(s.charAt(i) == ' ')
            {
                return count;
            }
            else{
            count ++;
            }

        }
        return count ;
    }
}