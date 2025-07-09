package util;

public class MessageConstants {
    //General UI
    public static final String WELCOME_MESSAGE = "=== Welcome to MyBank ===";
    public static final String MENU_MESSAGE = """
           1. Create Account
           2. Deposit
           3. Withdraw
           4. Compute Interest
           5. Display Account
           6. Exit
           """;
    public static final String GOODBYE_MESSAGE = "--- Thank you for using the bank ---";
    public static final String INTEREST_COMPUTE_MESSAGE = "Computing interest for account %s...\n";
    public static final String INTEREST_EARNED_MESSAGE = "Interest earned: %.2f\n";
    public static final String NEW_BALANCE_MESSAGE = "New balance: %.2f\n\n";
    public static final String ACCOUNT_INFO_MESSAGE = "--- Account Info ---";
    public static final String ACCOUNT_NUMBER_MESSAGE = "Account Number:\t%s. \n";
    public static final String ACCOUNT_HOLDER_MESSAGE = "Holder Name:\t%s. \n";
    public static final String ACCOUNT_BALANCE_MESSAGE = "Balance:\t%s. \n\n";

    // Success Messages
    public static final String ACCOUNT_CREATED_SUCCESS_MESSAGE = "Account created successfully!\n";
    public static final String DEPOSIT_SUCCESS_MESSAGE = "Deposit successful!\n";
    public static final String WITHDRAW_SUCCESS_MESSAGE = "Withdrawal successful!\n";

    //Prompts
    public static final String ENTER_CHOICE_PROMPT = "Enter choice: ";
    public static final String ENTER_ACCOUNT_TYPE_PROMPT = "\nEnter Account Type (savings/checking): ";
    public static final String ENTER_ACCOUNT_NUMBER_PROMPT = "Enter Account Number: ";
    public static final String ENTER_HOLDER_NAME_PROMPT = "Enter Holder Name: ";
    public static final String ENTER_INITIAL_DEPOSIT_PROMPT = "Initial Deposit: ";
    public static final String ENTER_DEPOSIT_AMOUNT_PROMPT = "Enter deposit amount: ";
    public static final String ENTER_WITHDRAWAL_AMOUNT_PROMPT = "Enter withdrawal amount: ";

    //Error messages
    public static final String AMOUNT_NEGATIVE_ERROR_MESSAGE = "Amount must be non-negative.";
    public static final String INSUFFICIENT_FUNDS_ERROR_MESSAGE = "Insufficient funds.";
    public static final String INVALID_ACCOUNT_TYPE_ERROR_MESSAGE = "Invalid account type.";
    public static final String INVALID_ACCOUNT_NUMBER_ERROR_MESSAGE = "Invalid account number.";
    public static final String INPUT_EMPTY_ERROR_MESSAGE = "Input cannot be empty.";
    public static final String ACCOUNT_EXISTS_ERROR_MESSAGE = "Account number already exists.\n";
    public static final String ACCOUNT_NOT_FOUND_ERROR_MESSAGE = "Account not found.";
    public static final String ERROR_PREFIX = "Error: %s \n\n";
    public static final String INVALID_CHOICE_ERROR_MESSAGE = "Invalid choice.\n";
    public static final String INVALID_NUMBER_ERROR_MESSAGE = "Invalid number, please try again.";
    public static final String DUPLICATE_ACCOUNT_ERROR_MESSAGE = "Attempted to create duplicate account: %s. \n";
    //AccountTypes
    public static final String SAVINGS_STRING = "SAVINGS";
    public static final String CHECKING_STRING = "CHECKING";
}