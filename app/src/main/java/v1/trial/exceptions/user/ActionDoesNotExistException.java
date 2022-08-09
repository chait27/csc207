package v1.trial.exceptions.user;

public class ActionDoesNotExistException extends RuntimeException {
    public ActionDoesNotExistException() { super("Desired action does not exist"); }
}
