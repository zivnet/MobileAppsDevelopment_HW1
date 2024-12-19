import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a new Bank
        Bank bank = new Bank();

        // Create different accounts
        IAccount standardAccount = new StandardAccount(1001, -200);
        IAccount basicAccount = new BasicAccount(1002, 100);
        IAccount premiumAccount = new PremiumAccount(1003);

        // Open accounts
        bank.OpenAccount(standardAccount);
        bank.OpenAccount(basicAccount);
        bank.OpenAccount(premiumAccount);

        // Deposit money into accounts
        standardAccount.Deposit(300);
        basicAccount.Deposit(150);
        premiumAccount.Deposit(500);

        // Withdraw money from accounts
        standardAccount.Withdraw(400);  // Leaves balance -100
        basicAccount.Withdraw(200);     // Withdraws only 100 due to limit
        premiumAccount.Withdraw(600);   // Leaves balance -100

        // Get all accounts
        System.out.println("All Accounts:");
        for (IAccount account : bank.GetAllAccounts()) {
            System.out.println("Account " + account.GetAccountNumber() + " Balance: " + account.GetCurrentBalance());
        }

        // Get all accounts in debt
        System.out.println("\nAccounts in Debt:");
        List<IAccount> accountsInDebt = bank.GetAllAccountsInDebt();
        for (IAccount account : accountsInDebt) {
            System.out.println("Account " + account.GetAccountNumber() + " Balance: " + account.GetCurrentBalance());
        }

        // Get all accounts with balance above 100
        System.out.println("\nAccounts with Balance above 100:");
        List<IAccount> accountsWithBalance = bank.GetAllAccountsWithBalance(100);
        for (IAccount account : accountsWithBalance) {
            System.out.println("Account " + account.GetAccountNumber() + " Balance: " + account.GetCurrentBalance());
        }

        // Try closing accounts
        bank.CloseAccount(1001);  // Should fail due to debt
        bank.CloseAccount(1002);  // Should succeed
        bank.CloseAccount(1003);  // Should succeed

        // Check remaining accounts
        System.out.println("\nRemaining Accounts After Closing:");
        for (IAccount account : bank.GetAllAccounts()) {
            System.out.println("Account " + account.GetAccountNumber() + " Balance: " + account.GetCurrentBalance());
        }
    }
}
