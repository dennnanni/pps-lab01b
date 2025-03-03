package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeBankAccountTest extends BankAccountTest {

    private static final int WITHDRAW = 50;

    @Override
    @BeforeEach
    public void init() {
        this.account = new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    public void testConditionalFee() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW);
        assertEquals(DEPOSIT - WITHDRAW, this.account.getBalance());
    }
}
