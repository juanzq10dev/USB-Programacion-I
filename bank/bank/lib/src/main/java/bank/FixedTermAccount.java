package bank;

import java.time.*;
import java.time.format.*;

public class FixedTermAccount extends Account {
    int fixedTerm;
    LocalDate withdrawDate;

    public FixedTermAccount(int fixedTerm, String personID) {
        super(personID);
        super.accountType = "Fixed Term Account";
        this.fixedTerm = fixedTerm;
        withdrawDate = super.creationDate.plusMonths(fixedTerm);
    }

    @Override
    public boolean depositMoney(double money, String date) {
        if (super.totalMoney == 0) {
            boolean result = super.depositMoney(money, date);
            return result;
        } else {
            return false;
        }
    }

    @Override
    public boolean withdrawMoney(double money, String date) {
        if (dateIsValid(date)) {
            boolean result = super.withdrawMoney(money, date);
            return result;
        } else {
            return false;
        }
    }

    private boolean dateIsValid(String date) {
        LocalDateTime actualDateTime;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            actualDateTime = LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("date format must be yyyy-MM-dd HH:mm");
        }

        LocalDate actualDate = actualDateTime.toLocalDate();

        if (actualDate.isAfter(withdrawDate) || actualDate.equals(withdrawDate)) {
            return true;
        } else {
            return false;
        }
    }
}
