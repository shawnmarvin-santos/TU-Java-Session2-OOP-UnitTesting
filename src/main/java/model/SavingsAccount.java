package model;

import configs.InterestConfiguration;
import org.springframework.stereotype.Component;

@Component
public class SavingsAccount extends Account{
    public SavingsAccount(String accountNumber, String holderName, double deposit) {
        super(accountNumber, holderName, deposit);
    }

    @Override
    public double computeInterest() {
        return getBalance() * InterestConfiguration.getSavingRate();
    }
}
