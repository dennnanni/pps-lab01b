package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BankAccountTest {

    private static final int WITHDRAW_WITH_FEE = 200;
    private static final int WITHDRAW = 50;

    public void init() {
        this.account = new CreditBankAccount(new FeeBankAccount(new CoreBankAccount(), amount -> amount > 100 ? 1 : 0));
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW_WITH_FEE);
        assertEquals(DEPOSIT - WITHDRAW_WITH_FEE - 1, this.account.getBalance());
    }

    @Test
    public void testConditionalFee() {
        this.account.deposit(DEPOSIT);
        this.account.withdraw(WITHDRAW);
        assertEquals(DEPOSIT - WITHDRAW, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}
