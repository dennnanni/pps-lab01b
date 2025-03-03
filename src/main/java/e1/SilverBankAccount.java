package e1;

public class SilverBankAccount extends DecoratorBankAccount {

    private static final int FEE = 1;

    public SilverBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if (amount + FEE > getBalance()) {
            throw new IllegalStateException();
        }
        super.withdraw(amount + FEE);
    }
}
