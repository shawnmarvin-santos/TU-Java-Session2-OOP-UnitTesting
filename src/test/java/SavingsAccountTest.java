import model.SavingsAccount;
import org.junit.jupiter.api.Test;
import util.MessageConstants;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    void savingsAccountDepositWithdrawInterest() {
        SavingsAccount sa = new SavingsAccount("001", "Ahsoka", 1000.0);
        sa.deposit(500);
        assertEquals(1500.0, sa.getBalance());
    }

    @Test
    void savingAccountWithdrawSuccess(){
        SavingsAccount sa = new SavingsAccount("001", "Ben", 1000.0);
        sa.withdraw(200);
        assertEquals(800.0, sa.getBalance());
    }

    @Test
    void savingAccountInterestSuccedd(){
        SavingsAccount sa = new SavingsAccount("001", "Em", 1000.0);
        double expectedInterest = 1000.0 * 0.03; // Hardcoded, or fetch from config if you wish
        assertEquals(expectedInterest, sa.computeInterest(), 0.0001);
        sa.deposit(sa.computeInterest());
        assertEquals(1000.0 + expectedInterest, sa.getBalance(), 0.0001);
    }

    @Test
    void negativeDepositThrows() {
        SavingsAccount sa = new SavingsAccount("003", "Mio", 100.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sa.deposit(-20));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void zeroDepositThrows() {
        SavingsAccount ca = new SavingsAccount("004", "Mai", 50.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ca.deposit(0));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void negativeWithdrawThrows() {
        SavingsAccount ca = new SavingsAccount("005", "Zel", 50.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ca.withdraw(-20));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void zeroWithdrawThrows() {
        SavingsAccount ca = new SavingsAccount("006", "Joshua", 50.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ca.withdraw(0));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void overWithdrawThrows() {
        SavingsAccount sa = new SavingsAccount("007", "CJ", 10.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sa.withdraw(20));
        assertEquals(MessageConstants.INSUFFICIENT_FUNDS_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void initialNegativeDepositThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new SavingsAccount("008", "Henry", -1));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void getAccountNumberAndHolder() {
        SavingsAccount ca = new SavingsAccount("009", "Shawn", 100);
        assertEquals("009", ca.getAccountNumber());
        assertEquals("Shawn", ca.getHolderName());
    }
}