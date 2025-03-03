package e1;

public class BronzeBankAccount extends DecoratorBankAccount {

    private static final int MAX_WITHDRAW_WITHOUT_FEE = 100;
    private static final int FEE = 1;

    public BronzeBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        int fee = amount > MAX_WITHDRAW_WITHOUT_FEE ? FEE : 0;
        if (amount + fee > getBalance()) {
            throw new IllegalStateException();
        }
        super.withdraw(amount + fee);
    }
}
