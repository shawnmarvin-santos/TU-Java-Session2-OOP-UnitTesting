package model;

import util.MessageConstants;

public enum AccountType {
    SAVINGS, CHECKING;

    public static AccountType fromString(String type) throws IllegalArgumentException{
        return switch (type.toUpperCase()){
            case MessageConstants.SAVINGS_STRING -> SAVINGS;
            case MessageConstants.CHECKING_STRING -> CHECKING;
            default -> throw new IllegalArgumentException(MessageConstants.INVALID_ACCOUNT_TYPE_ERROR_MESSAGE);
        };
    }
}
