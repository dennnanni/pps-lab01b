package e1;

public class BankAccountFactoryImpl implements BankAccountFactory {
    @Override
    public DecoratorBankAccount createSilverBankAccount() {
        return new DebitBankAccount(new FeeBankAccount(new CoreBankAccount(), amount -> 1));
    }

    @Override
    public DecoratorBankAccount createBronzeBankAccount() {
        return new DebitBankAccount(new FeeBankAccount(new CoreBankAccount(), amount -> amount > 100 ? 1 : 0));
    }

    @Override
    public DecoratorBankAccount createGoldBankAccount() {
        return new CreditBankAccount(new CoreBankAccount(), 500);
    }
}
