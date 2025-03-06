package e1;

public class DebitBankAccount extends DecoratorBankAccount {

    public DebitBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if (amount > getBalance()) {
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
