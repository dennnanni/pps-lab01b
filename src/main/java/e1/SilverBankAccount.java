package e1;

public class SilverBankAccount extends DecoratorBankAccount {

    public SilverBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public int getFee(int amount) {
        return amount < 100 ? 0 : 1;
    }

}
