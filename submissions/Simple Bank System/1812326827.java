# Title: Simple Bank System
# Submission ID: 1812326827
# Status: Accepted
# Date: October 26, 2025 at 08:41:50 PM GMT+5:30

class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (
            account1 > balance.length ||
            account2 > balance.length ||
            balance[account1 - 1] < money
        ) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > balance.length) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > balance.length || balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}