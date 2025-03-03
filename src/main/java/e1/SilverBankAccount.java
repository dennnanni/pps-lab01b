package e1;

public class SilverBankAccount extends DecoratorBankAccount {

    public SilverBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public int getFee() {
        return 1;
    }

}
