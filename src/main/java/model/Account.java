package model;

import util.InputUtils;

import static util.MessageConstants.*;

public abstract class Account implements AccountOperations{

    private final String accountNumber;
    private final String holderName;
    private double balance;

    public Account(String accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = validateAndReturnBalance(initialDeposit);
    }

    private double validateAndReturnBalance(double initialDeposit) {
        InputUtils.validateNonNegative(initialDeposit);
        return initialDeposit;
    }

    @Override
    public void deposit(double amount) {
        InputUtils.validateNonNegative(amount);
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws IllegalArgumentException {
        InputUtils.validateNonNegative(amount);
        if(amount > balance){
            throw new IllegalArgumentException(INSUFFICIENT_FUNDS_ERROR_MESSAGE);
        }
        balance -= amount;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
