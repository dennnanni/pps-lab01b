package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest extends BankAccountTest {

    private static final int WITHDRAW = 1200;

    @Override
    @BeforeEach
    public void init() {
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdrawMoreThanBalance() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW);
        assertEquals(DEPOSIT - WITHDRAW - this.account.getFee(DEPOSIT + WITHDRAW), this.account.getBalance());
    }

}
