import model.CheckingAccount;
import org.junit.jupiter.api.Test;
import util.MessageConstants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckingAccountTest {

    @Test
    void CheckingAccountDepositWithdrawInterest() {
        CheckingAccount sa = new CheckingAccount("001", "Ahsoka", 1000.0);
        sa.deposit(500);
        assertEquals(1500.0, sa.getBalance());
    }

    @Test
    void savingAccountWithdrawSuccess(){
        CheckingAccount sa = new CheckingAccount("001", "Ben", 1000.0);
        sa.withdraw(200);
        assertEquals(800.0, sa.getBalance());
    }

    @Test
    void savingAccountInterestSuccedd(){
        CheckingAccount sa = new CheckingAccount("001", "Em", 1000.0);
        double expectedInterest = 1000.0 * 0.04; // Hardcoded, or fetch from config if you wish
        assertEquals(expectedInterest, sa.computeInterest(), 0.0001);
        sa.deposit(sa.computeInterest());
        assertEquals(1000.0 + expectedInterest, sa.getBalance(), 0.0001);
    }

    @Test
    void negativeDepositThrows() {
        CheckingAccount sa = new CheckingAccount("003", "Mio", 100.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sa.deposit(-20));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void zeroDepositThrows() {
        CheckingAccount ca = new CheckingAccount("004", "Mai", 50.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ca.deposit(0));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void negativeWithdrawThrows() {
        CheckingAccount ca = new CheckingAccount("005", "Zel", 50.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ca.withdraw(-20));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void zeroWithdrawThrows() {
        CheckingAccount ca = new CheckingAccount("006", "Joshua", 50.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ca.withdraw(0));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void overWithdrawThrows() {
        CheckingAccount sa = new CheckingAccount("007", "CJ", 10.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sa.withdraw(20));
        assertEquals(MessageConstants.INSUFFICIENT_FUNDS_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void initialNegativeDepositThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new CheckingAccount("008", "Henry", -1));
        assertEquals(MessageConstants.AMOUNT_NEGATIVE_ERROR_MESSAGE, ex.getMessage());
    }

    @Test
    void getAccountNumberAndHolder() {
        CheckingAccount ca = new CheckingAccount("009", "Shawn", 100);
        assertEquals("009", ca.getAccountNumber());
        assertEquals("Shawn", ca.getHolderName());
    }
}