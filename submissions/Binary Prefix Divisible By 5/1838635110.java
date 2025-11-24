# Title: Binary Prefix Divisible By 5
# Submission ID: 1838635110
# Status: Accepted
# Date: November 24, 2025 at 09:10:09 PM GMT+5:30

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int val = 0;
        for(int ele : nums){
            val = ((val*2)+ele)%5;
            ans.add(val==0);
        }
        return  ans;
    }
}