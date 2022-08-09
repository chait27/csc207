package v1.trial.exceptions.user;

public class PasswordsDontMatchException extends RuntimeException {
    public PasswordsDontMatchException() { super("Old password does not match entered password."); }
}
