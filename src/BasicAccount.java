public class BasicAccount implements IAccount {
    // Fields
    private double balance;
    private int accountNumber;
    private double withdrawalLimit;

    // Constructor
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;

        // Ensure the withdrawal limit is positive
        this.withdrawalLimit = (withdrawalLimit > 0) ? withdrawalLimit : 0.0;

        // Initial balance is 0
        this.balance = 0.0;
    }

    // Deposit Method
    @Override
    public void Deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    @Override
    public double Withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return 0.0;
        }

        // Limit withdrawal to account balance and withdrawal limit
        double maxWithdrawal = Math.min(balance, withdrawalLimit);
        double withdrawnAmount = Math.min(amount, maxWithdrawal);

        if (withdrawnAmount > 0) {
            balance -= withdrawnAmount;
            System.out.println("Withdrew: " + withdrawnAmount);
        } else {
            System.out.println("Withdrawal denied. Insufficient funds.");
        }

        return withdrawnAmount;
    }

    // GetCurrentBalance Method
    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    // GetAccountNumber Method
    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
