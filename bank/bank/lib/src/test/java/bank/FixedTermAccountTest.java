package bank;

import org.junit.Test;
import static org.junit.Assert.*;

public class FixedTermAccountTest {

    @Test
    public void testDepositMoneyShouldDepositMoneyOnlyFirstTime() {
        FixedTermAccount fixedTermAccount = new FixedTermAccount(12, "123");
        boolean result = fixedTermAccount.depositMoney(50.0, "2030-05-21 12:30");
        assertTrue(result);
        result = fixedTermAccount.depositMoney(50.0, "2030-05-21 12:30");
        assertFalse(result);
    }

    @Test
    public void testWithDrawMoneyShouldReturTrueIfDateIsAfterFixedTerm() {
        FixedTermAccount fixedTermAccount = new FixedTermAccount(12, "123");
        fixedTermAccount.depositMoney(50.0, "2030-05-21 12:30");
        boolean result = fixedTermAccount.withdrawMoney(50.0, "2030-05-21 12:30");
        assertTrue(result);
    }

    @Test
    public void testWithDrawMoneyShouldReturFalseIfDateIsBeforeFixedTerm() {
        FixedTermAccount fixedTermAccount = new FixedTermAccount(12, "123");
        fixedTermAccount.depositMoney(50.0, "2030-05-21 12:30");
        boolean result = fixedTermAccount.withdrawMoney(50.0, "2019-05-21 12:30");
        assertFalse(result);
    }

}
