package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest {

    private static final int WITHDRAW_1 = 200;

    @Override
    @BeforeEach
    public void init() {
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

}
