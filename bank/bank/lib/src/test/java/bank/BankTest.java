package bank;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BankTest {
    @Test
    public void testCreateFixedTermAccountShouldCreateAnAccount() {
        Bank bank = new Bank();
        boolean result = bank.createFixedTermAccount("Juan", "Zurita", "123patito", "Always Live Av.", 12435,
                "Administrator", "Juan.Zurita@fundacion-jala.org", 12);
        assertTrue(result);
    }

    @Test
    public void testCreateSaveAccountShouldCreateAnAccount() {
        Bank bank = new Bank();
        boolean result = bank.createSaveAccount("Juan", "Zurita", "123patito", "AlwaysLive", 12345, "Admin",
                "juan.zurita@fundacion-jala.org");
        assertTrue(result);
    }

    @Test
    public void testCreateFixedTermAccountShouldNotCreateAnAccountIfAccountExists() {
        Bank bank = new Bank();
        bank.createFixedTermAccount("Juan", "Zurita", "123patito", "Always Live Av.", 12435, "Administrator",
                "Juan.Zurita@fundacion-jala.org", 12);
        boolean result = bank.createFixedTermAccount("Juan", "Zurita", "123patito", "Always Live Av.", 12435,
                "Administrator", "Juan.Zurita@fundacion-jala.org", 12);
        assertFalse(result);

    }

    @Test
    public void testCreateSaveAccountShouldNotCreateAnAccountIfAccountExists() {
        Bank bank = new Bank();
        bank.createSaveAccount("Juan", "Zurita", "123patito", "AlwaysLive", 12345, "Admin",
                "juan.zurita@fundacion-jala.org");
        boolean result = bank.createSaveAccount("Juan", "Zurita", "123patito", "AlwaysLive", 12345, "Admin",
                "juan.zurita@fundacion-jala.org");
        assertFalse(result);
    }

    @Test
    public void testObtainAccount() {
        Account account = new Account("123");
        Bank bank = new Bank();
        bank.createSaveAccount("Juan", "Zurita", "123", "AlwaysLive", 12345, "Admin", "juan.zurita@fundacion-jala.org");
        Account returnedAccount = bank.obtainAccount("123", "Save Account");
        boolean result = account.equals(returnedAccount);
        assertTrue(result);
    }
}
