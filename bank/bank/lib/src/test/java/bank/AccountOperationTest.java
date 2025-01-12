package bank;

import org.junit.Test;
import static org.junit.Assert.*;
public class AccountOperationTest {
    @Test 
    public void AccountOperationShouldNotBeCreatedIfDateFormatIsIncorrect(){
        assertThrows(IllegalArgumentException.class, () -> new AccountOperation(12, "WITHDRAW", "2020/12/12 13:58"));
    }
}
