package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AccountOperation {
    double money;
    String operationName;
    LocalDateTime date;

    public AccountOperation(double money, String operationName, String date) {
        this.money = money;
        this.operationName = operationName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            this.date = LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("date format must be yyyy-MM-dd HH:mm");
        }
    }

    public double getMoney() {
        return money;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
