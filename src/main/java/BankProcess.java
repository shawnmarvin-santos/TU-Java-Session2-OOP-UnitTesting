import model.AccountOperations;
import model.AccountType;
import model.CheckingAccount;
import model.SavingsAccount;
import util.InputUtils;
import static util.MessageConstants.*;

import java.util.*;

public class BankProcess {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, AccountOperations> accounts = new HashMap<>();

    public static void main(String[] args) {
        activateMenu();
    }

    private static void activateMenu() {
        System.out.println(WELCOME_MESSAGE);
        boolean menuActivated = true;
        while (menuActivated) {
            try {
                System.out.print(MENU_MESSAGE);
                System.out.print(ENTER_CHOICE_PROMPT);
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1 :
                        createAccount();
                        break;
                    case 2 :
                        deposit();
                        break;
                    case 3 :
                        withdraw();
                        break;
                    case 4 :
                        computeInterest();
                        break;
                    case 5 :
                        displayAccount();
                        break;
                    case 6 :
                        System.out.println(GOODBYE_MESSAGE);
                        menuActivated = false;
                        break;
                    default:
                        System.out.println(INVALID_CHOICE_ERROR_MESSAGE);
                        break;
                }
            } catch (Exception e) {
                System.out.printf(ERROR_PREFIX,e.getMessage());
            }
        }
    }

    private static void createAccount() {
        try {
            String typeInput = InputUtils.promptNonEmpty(scanner, ENTER_ACCOUNT_TYPE_PROMPT);
            AccountType type = AccountType.fromString(typeInput);

            String accountNumber = InputUtils.promptNumericString(scanner, ENTER_ACCOUNT_NUMBER_PROMPT);
            if (accounts.containsKey(accountNumber)) {
                System.out.println(ACCOUNT_EXISTS_ERROR_MESSAGE);
                System.out.printf(DUPLICATE_ACCOUNT_ERROR_MESSAGE, accountNumber);
                return;
            }
            String accountHolder = InputUtils.promptNonEmpty(scanner, ENTER_HOLDER_NAME_PROMPT);
            double initialDeposit = InputUtils.promptForDouble(scanner, ENTER_INITIAL_DEPOSIT_PROMPT);

            AccountOperations accountOperations = switch (type) {
                case SAVINGS -> new SavingsAccount(accountNumber, accountHolder, initialDeposit);
                case CHECKING -> new CheckingAccount(accountNumber, accountHolder, initialDeposit);
            };

            accounts.put(accountNumber, accountOperations);
            System.out.println(ACCOUNT_CREATED_SUCCESS_MESSAGE);

        } catch (Exception e) {
            System.out.printf(ERROR_PREFIX, e.getMessage());
        }
    }

    private static AccountOperations getAccountPrompt() {
        String accountNumber = InputUtils.promptNonEmpty(scanner, ENTER_ACCOUNT_NUMBER_PROMPT);
        AccountOperations acc = accounts.get(accountNumber);
        if (acc == null) {
            throw new NoSuchElementException(ACCOUNT_NOT_FOUND_ERROR_MESSAGE);
        }
        return acc;
    }

    private static void deposit() {
        try {
            AccountOperations accountOperations = getAccountPrompt();
            double amount = InputUtils.promptForDouble(scanner, ENTER_DEPOSIT_AMOUNT_PROMPT);
            accountOperations.deposit(amount);
            System.out.println(DEPOSIT_SUCCESS_MESSAGE);
        } catch (Exception e) {
            System.out.printf(ERROR_PREFIX, e.getMessage());
        }
    }

    private static void withdraw() {
        try {
            AccountOperations accountOperations = getAccountPrompt();
            double amount = InputUtils.promptForDouble(scanner, ENTER_WITHDRAWAL_AMOUNT_PROMPT);
            accountOperations.withdraw(amount);
            System.out.println(WITHDRAW_SUCCESS_MESSAGE);
        } catch (Exception e) {
            System.out.printf(ERROR_PREFIX, e.getMessage());
        }
    }

    private static void computeInterest() {
        try {
            AccountOperations accountOperations = getAccountPrompt();
            System.out.printf(INTEREST_COMPUTE_MESSAGE, accountOperations.getAccountNumber());
            double interest = accountOperations.computeInterest();
            accountOperations.deposit(interest);
            System.out.printf(INTEREST_EARNED_MESSAGE, interest);
            System.out.printf(NEW_BALANCE_MESSAGE, accountOperations.getBalance());
        } catch (Exception e) {
            System.out.printf(ERROR_PREFIX, e.getMessage());
        }
    }

    private static void displayAccount() {
        try {
            AccountOperations accountOperations = getAccountPrompt();
            showAccount(accountOperations);
        } catch (Exception e) {
            System.out.printf(ERROR_PREFIX, e.getMessage());
        }
    }

    private static void showAccount(AccountOperations account) {
        System.out.println(ACCOUNT_INFO_MESSAGE);
        System.out.printf(ACCOUNT_NUMBER_MESSAGE, account.getAccountNumber());
        System.out.printf(ACCOUNT_HOLDER_MESSAGE, account.getHolderName());
        System.out.printf(ACCOUNT_BALANCE_MESSAGE, account.getBalance());
    }
}