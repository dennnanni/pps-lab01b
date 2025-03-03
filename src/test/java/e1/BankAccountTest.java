package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    protected static final int DEPOSIT = 1000;
    private static final int WITHDRAW = 200;
    protected DecoratorBankAccount account;

    @BeforeEach
    public abstract void init();

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT);
        assertEquals(DEPOSIT, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW);
        assertEquals(DEPOSIT - WITHDRAW - this.account.getFee(WITHDRAW), this.account.getBalance());
    }
}
