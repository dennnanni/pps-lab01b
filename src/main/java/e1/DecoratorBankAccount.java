package e1;

public class DecoratorBankAccount implements BankAccount {

    private BankAccount base;

    public DecoratorBankAccount(final BankAccount base){
        this.base = base;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + getFee(amount));
    }

    public int getFee(int amount) {
        return 0;
    }

    public boolean canWithdraw(int amount) {
        return true;
    }
}
