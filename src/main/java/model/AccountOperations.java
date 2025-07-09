package model;

public interface AccountOperations {
    void deposit(double amount);
    void withdraw(double amount) throws IllegalArgumentException;
    double computeInterest();

    String getAccountNumber();
    String getHolderName();
    double getBalance();
}
