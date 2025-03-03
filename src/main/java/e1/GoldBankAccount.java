package e1;

public class GoldBankAccount extends DecoratorBankAccount {

    private static final int MAX_DEBIT = 500;

    public GoldBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if (amount > getBalance() + MAX_DEBIT) {
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
