package bank;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void testDepositMoneyShouldAddTotalMoney() {
        Account account = new Account("1234");
        account.depositMoney(12, "2021-12-15 15:59");
        double result = account.getTotalMoney();
        double expected = 12;
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testWithdrawShouldWithdrawMoney() {
        Account account = new Account("1234");
        account.depositMoney(100, "2021-12-15 15:59");
        assertTrue(account.withdrawMoney(100, "2021-12-15 16:59"));
    }

    @Test
    public void testWithdrawShouldNotWithdrawMoneyIfThereIsNotEnoughtMoney() {
        Account account = new Account("1234");
        account.depositMoney(100, "2021-12-15 15:59");
        assertFalse(account.withdrawMoney(150, "2021-12-15 16:59"));
    }

    @Test
    public void testEqualsShouldReturnTrueIdAccountsAreEqual() {
        Account account = new Account("1234");
        Account account2 = new Account("1234");
        boolean expected = account.equals(account2);
        assertTrue(expected);
    }

    @Test
    public void testEqualsShouldReturnFalseIsAccountsAreNotEqual() {
        Account account = new Account("1234");
        FixedTermAccount account2 = new FixedTermAccount(12, "1234");
        boolean result = account.equals(account2);
        assertFalse(result);
        Account account3 = new Account("12345");
        result = account.equals(account3);
        assertFalse(result);

    }

    @Test
    public void testMatchesShouldReturnTrue() {
        Account account = new Account("1234");
        boolean result = account.matches("1234", "Save Account");
        assertTrue(result);

    }

    @Test
    public void testMatchesShouldReturnFalse() {
        Account account = new Account("1234");
        boolean result = account.matches("1235", "Save Account");
        assertFalse(result);

    }

}
