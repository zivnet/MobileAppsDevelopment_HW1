import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a new Bank
        Bank bank = new Bank();

        // Create two accounts of each type
        // Standard Accounts
        IAccount standardAccount1 = new StandardAccount(1001, -200);
        IAccount standardAccount2 = new StandardAccount(1002, -300);

        // Basic Accounts
        IAccount basicAccount1 = new BasicAccount(1003, 100);
        IAccount basicAccount2 = new BasicAccount(1004, 150);

        // Premium Accounts
        IAccount premiumAccount1 = new PremiumAccount(1005);
        IAccount premiumAccount2 = new PremiumAccount(1006);

        // Open accounts in the bank
        bank.OpenAccount(standardAccount1);
        bank.OpenAccount(standardAccount2);
        bank.OpenAccount(basicAccount1);
        bank.OpenAccount(basicAccount2);
        bank.OpenAccount(premiumAccount1);
        bank.OpenAccount(premiumAccount2);

        // Perform deposits
        standardAccount1.Deposit(300);
        standardAccount2.Deposit(400);
        basicAccount1.Deposit(150);
        basicAccount2.Deposit(200);
        premiumAccount1.Deposit(500);
        premiumAccount2.Deposit(600);

        // Perform withdrawals
        standardAccount1.Withdraw(400);  // Leaves balance -100
        standardAccount2.Withdraw(500);  // Leaves balance -100
        basicAccount1.Withdraw(200);     // Withdraws only 100 due to limit
        basicAccount2.Withdraw(300);     // Withdraws only 150 due to limit
        premiumAccount1.Withdraw(600);   // Leaves balance -100
        premiumAccount2.Withdraw(700);   // Leaves balance -100

        // Display all accounts
        System.out.println("All Accounts:");
        for (IAccount account : bank.GetAllAccounts()) {
            System.out.println("Account " + account.GetAccountNumber() + " Balance: " + account.GetCurrentBalance());
        }

        // Display accounts in debt
        System.out.println("\nAccounts in Debt:");
        List<IAccount> accountsInDebt = bank.GetAllAccountsInDebt();
        for (IAccount account : accountsInDebt) {
            System.out.println("Account " + account.GetAccountNumber() + " Balance: " + account.GetCurrentBalance());
        }

        // Display accounts with balance above 100
        System.out.println("\nAccounts with Balance above 100:");
        List<IAccount> accountsWithBalance = bank.GetAllAccountsWithBalance(100);
        for (IAccount account : accountsWithBalance) {
            System.out.println("Account " + account.GetAccountNumber() + " Balance: " + account.GetCurrentBalance());
        }

        // Attempt to close accounts
        bank.CloseAccount(1001);  // Should fail due to debt
        bank.CloseAccount(1003);  // Should succeed
        bank.CloseAccount(1005);  // Should succeed

        // Display remaining accounts
        System.out.println("\nRemaining Accounts After Closing:");
        for (IAccount account : bank.GetAllAccounts()) {
            System.out.println("Account " + account.GetAccountNumber() + " Balance: " + account.GetCurrentBalance());
        }
    }
}
