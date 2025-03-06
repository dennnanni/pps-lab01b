package e1;

public class CreditBankAccount extends DecoratorBankAccount {

    private int credit = 0;

    public CreditBankAccount(BankAccount base) {
        super(base);
    }

    public CreditBankAccount(BankAccount base, int credit) {
        super(base);
        this.credit = credit;
    }

    @Override
    public void withdraw(int amount) {
        if (amount > getBalance() + credit) {
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
