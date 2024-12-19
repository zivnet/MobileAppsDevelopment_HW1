public class StandardAccount implements IAccount {
    // Fields
    private double balance;
    private int accountNumber;
    private double creditLimit;

    // Constructor
    public StandardAccount(int accountNumber, double creditLimit) {
        // Assign the account number
        this.accountNumber = accountNumber;

        // Validate credit limit (must be negative, otherwise set to 0)
        this.creditLimit = (creditLimit < 0) ? creditLimit : 0.0;

        // Initialize balance
        this.balance = 0.0;
    }

    // Methods to implement from IAccount
    @Override
    public void Deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public double Withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return 0.0;
        }

        double maxWithdrawal = balance - creditLimit;  // Maximum withdrawal allowed
        double withdrawnAmount = Math.min(amount, maxWithdrawal);

        if (withdrawnAmount > 0) {
            balance -= withdrawnAmount;
            System.out.println("Withdrew: " + withdrawnAmount);
        } else {
            System.out.println("Withdrawal denied. Insufficient funds.");
        }

        return withdrawnAmount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
