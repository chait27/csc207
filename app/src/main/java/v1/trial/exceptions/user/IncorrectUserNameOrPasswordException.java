package v1.trial.exceptions.user;

public class IncorrectUserNameOrPasswordException extends RuntimeException {
    public IncorrectUserNameOrPasswordException () {
        super("Incorrect username or password");
    }
}
