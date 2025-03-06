package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    protected static final int DEPOSIT = 1000;
    protected DecoratorBankAccount account;

    public abstract void init();

    @BeforeEach
    public void setUp() {
        this.init();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT);
        assertEquals(DEPOSIT, this.account.getBalance());
    }
}
