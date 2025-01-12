package bank;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    protected double totalMoney;
    protected ArrayList<AccountOperation> accountData;
    protected String personID;
    protected String accountType;
    protected LocalDate creationDate;

    public Account(String personID) {
        this.accountType = "Save Account";
        this.personID = personID;
        creationDate = LocalDate.now();
        accountData = new ArrayList<AccountOperation>();
    }

    public boolean depositMoney(double money, String date) {
        totalMoney += money;
        addOperationToAccountData(money, "DEPOSIT", date);
        return true;
    }

    public boolean withdrawMoney(double money, String date) {
        if (totalMoneyIsEnought(money)) {
            totalMoney -= money;
            addOperationToAccountData(money, "WITHDRAW", date);
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Account account) {
        String accountPersonID = account.personID;
        String accountType = account.accountType;
        boolean accountPersonIDIsEqual = accountPersonID == this.personID;
        boolean accountTypeISEqual = accountType == this.accountType;
        if (accountTypeISEqual && accountPersonIDIsEqual) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matches(String personID, String type) {
        boolean personIDISEqual = personID == this.personID;
        boolean accountTypeISEqual = type.equals(this.accountType);
        if (personIDISEqual && accountTypeISEqual) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean totalMoneyIsEnought(double money) {
        if (money <= totalMoney) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean addOperationToAccountData(double money, String operationName, String date) {
        AccountOperation accountOperation = new AccountOperation(money, operationName, date);
        boolean result = accountData.add(accountOperation);
        return result;
    }

    public double getTotalMoney() {
        return totalMoney;
    }
}
