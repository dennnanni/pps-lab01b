package e1;

public class SilverBankAccount extends DecoratorBankAccount {

    private static final int MAX_WITHDRAW_WITHOUT_FEE = 100;
    private static final int FEE = 1;

    public SilverBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public int getFee(int amount) {
        return amount < MAX_WITHDRAW_WITHOUT_FEE ? 0 : FEE;
    }

}
