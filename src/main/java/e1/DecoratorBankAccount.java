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
        base.withdraw(amount);
    }
}
