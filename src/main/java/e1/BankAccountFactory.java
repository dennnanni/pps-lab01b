package e1;

public interface BankAccountFactory {

    DecoratorBankAccount createSilverBankAccount();

    DecoratorBankAccount createBronzeBankAccount();

    DecoratorBankAccount createGoldBankAccount();
}
