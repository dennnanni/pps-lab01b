package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BankAccountTest {

    private static final int WITHDRAW = 1200;
    private static final int WITHDRAW_MORE_THAN_LIMIT = 1600;

    public void init() {
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW);
        assertEquals(DEPOSIT - WITHDRAW, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanBalance() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW);
        assertEquals(DEPOSIT - WITHDRAW, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanBalancePlusLimit() {
        this.account.deposit(DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(WITHDRAW_MORE_THAN_LIMIT));
    }

}
