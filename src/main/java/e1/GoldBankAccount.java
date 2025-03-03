package e1;

public class GoldBankAccount extends DecoratorBankAccount {

    public GoldBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public boolean canWithdraw(int amount) {
        return amount + getFee(amount) <= this.getBalance() + 500;
    }
}
