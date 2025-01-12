package bank;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accountsList;

    public Bank() {
        accountsList = new ArrayList<Account>();
    }

    public boolean createSaveAccount(String name, String lastName, String ID, String Address, int cellPhoneNumber,
            String occupation, String email) {
        Account account = new Account(ID);
        return registerAccount(account);

    }

    public boolean createFixedTermAccount(String name, String lastName, String ID, String Address, int cellPhoneNumber,
            String occupation, String email, int fixedTerm) {
        Account account = new FixedTermAccount(fixedTerm, ID);
        return registerAccount(account);

    }

    public Account obtainAccount(String personID, String AccountType) {
        for (Account account : accountsList) {
            if (account.matches(personID, AccountType)) {
                return account;
            }
        }
        return null;
    }

    private boolean accountExists(Account account) {
        for (Account index : accountsList) {
            if (account.equals(index)) {
                return true;
            }
        }
        return false;
    }

    private boolean registerAccount(Account account) {
        if (accountExists(account)) {
            return false;
        } else {
            accountsList.add(account);
            return true;
        }
    }

}
