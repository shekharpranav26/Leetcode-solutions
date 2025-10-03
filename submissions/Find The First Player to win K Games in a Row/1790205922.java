# Title: Find The First Player to win K Games in a Row
# Submission ID: 1790205922
# Status: Accepted
# Date: October 3, 2025 at 07:34:48 PM GMT+5:30

class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int winCount=0;
        int winIdx=0;
        for(int i=1;i<skills.length;i++){
            // assume 1st elemnt is winner and check next elemt is leess than and increment 1 
            if(skills[winIdx]>skills[i]){
                winCount++;
            }
            // else update the idx and count of wins
            else {
                winCount=1;
                winIdx=i;
            }
            // check winnercount==K then return it
            if(winCount==k){
                return winIdx;
            }
        }
        // if k >= n, the max skill player will eventually win
        int maxIdx = 0;
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] > skills[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }
}