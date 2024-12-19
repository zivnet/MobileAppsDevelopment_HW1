public class PremiumAccount implements IAccount {
    // Fields
    private double balance;
    private int accountNumber;

    // Constructor
    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;  // Initial balance
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

    // Withdraw Method (No Limit)
    @Override
    public double Withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            return amount;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return 0.0;
        }
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
