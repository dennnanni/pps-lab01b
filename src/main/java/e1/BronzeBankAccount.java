package e1;

public class BronzeBankAccount extends DecoratorBankAccount {

    private static final int MAX_WITHDRAW_WITHOUT_FEE = 100;
    private static final int FEE = 1;

    public BronzeBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public int getFee(int amount) {
        return amount < MAX_WITHDRAW_WITHOUT_FEE ? 0 : FEE;
    }

    @Override
    public boolean canWithdraw(int amount) {
        System.out.println(getBalance() >= amount + getFee(amount));
        return getBalance() >= amount + getFee(amount);
    }
}
