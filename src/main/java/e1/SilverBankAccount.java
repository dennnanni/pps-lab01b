package e1;

public class SilverBankAccount extends DecoratorBankAccount {

    public SilverBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public int getFee(int amount) {
        return 1;
    }

    @Override
    public boolean canWithdraw(int amount) {
        return amount + getFee(amount) <= this.getBalance();
    }
}
