import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    // List to hold all accounts
    private List<IAccount> accounts;

    // Constructor
    public Bank() {
        accounts = new ArrayList<>();
    }

    // OpenAccount Method
    @Override
    public void OpenAccount(IAccount account) {
        if (account != null) {
            accounts.add(account);
            System.out.println("Account opened: " + account.GetAccountNumber());
        }
    }

    // CloseAccount Method
    @Override
    public void CloseAccount(int accountNumber) {
        IAccount accountToRemove = null;

        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0) {
                    accountToRemove = account;
                    System.out.println("Account closed: " + accountNumber);
                } else {
                    System.out.println("Account " + accountNumber + " cannot be closed due to debt.");
                }
                break;
            }
        }
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
        }
    }

    // GetAllAccounts Method
    @Override
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(accounts);
    }

    // GetAllAccountsInDebt Method
    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                accountsInDebt.add(account);
            }
        }
        return accountsInDebt;
    }

    // GetAllAccountsWithBalance Method
    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }
}
