package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private static final int DEPOSIT = 1000;
    private static final int WITHDRAW_1 = 200;
    private static final int WITHDRAW_2 = 50;
    private DecoratorBankAccount account;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new DecoratorBankAccount(new CoreBankAccount()));
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

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW_1);
        assertEquals(DEPOSIT - WITHDRAW_1 - this.account.getFee(DEPOSIT + WITHDRAW_1), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

    @Test
    public void testConditionalFee() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW_2);
        assertEquals(DEPOSIT - WITHDRAW_2, this.account.getBalance());
    }

}
