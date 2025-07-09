package util;

import java.util.Scanner;

import static util.MessageConstants.*;

public class InputUtils {
    public static void validateNonNegative(double value){
        if (value <= 0){
            throw new IllegalArgumentException(AMOUNT_NEGATIVE_ERROR_MESSAGE);
        }
    }

    public static double promptForDouble(Scanner scanner, String prompt){
        while (true) {
            try{
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.println(INVALID_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public static String promptNumericString(Scanner scanner, String prompt){
        while (true){
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("[0-9]+")) {
                return input;
            }
            System.out.println(INVALID_ACCOUNT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static String promptNonEmpty(Scanner scanner, String prompt){
        while (true){
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.isEmpty()){
                return input;
            }
            System.out.println(INPUT_EMPTY_ERROR_MESSAGE);
        }
    }
}
