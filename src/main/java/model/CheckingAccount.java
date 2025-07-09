package model;

import configs.InterestConfiguration;
import org.springframework.stereotype.Component;

@Component
public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber, String holderName, double deposit) {
        super(accountNumber, holderName, deposit);
    }

    @Override
    public double computeInterest() {
        return getBalance() * InterestConfiguration.getCheckingRate();
    }
}
