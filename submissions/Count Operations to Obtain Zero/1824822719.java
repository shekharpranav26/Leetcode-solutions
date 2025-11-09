# Title: Count Operations to Obtain Zero
# Submission ID: 1824822719
# Status: Accepted
# Date: November 9, 2025 at 11:26:23 AM GMT+5:30

class Solution 
{
    public int countOperations(int num1, int num2) 
    {
        int res = 0;
        while (num1 != 0 && num2 != 0) 
        {
            res += num1 / num2;
            num1 %= num2;
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        return res;
    }
}