package Exceptitons;

/**
 * an exception for if someone trys to withdraw more funds then what is in the vault.
 */
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
