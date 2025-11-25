# Title: Smallest Integer Divisible by K
# Submission ID: 1839408892
# Status: Accepted
# Date: November 25, 2025 at 06:42:15 PM GMT+5:30

class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k==1) return 1;

        // Numbers made of only 1s can NEVER be divisible by 2 or 5
        if(k%2==0 || k%5==0) return -1;

        int rem = 0;
        for(int i=1;i<=k;i++){
            rem = (rem*10+1)%k;
            if(rem==0) return i;
        }
        return -1;
    }
}