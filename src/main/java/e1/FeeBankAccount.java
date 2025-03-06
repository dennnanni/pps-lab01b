package e1;

import java.util.function.Function;

public class FeeBankAccount extends DecoratorBankAccount {

    private Function<Integer, Integer> feeCalculator;

    public FeeBankAccount(BankAccount base, Function<Integer, Integer> feeCalculator) {
        super(base);
        this.feeCalculator = feeCalculator;
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + feeCalculator.apply(amount));
    }
}
