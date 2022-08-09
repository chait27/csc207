package v1.trial.exceptions.user;

public class UserDoesNotExistException extends UsernameException {
    public UserDoesNotExistException(final String username) {
        super(username, "User %s does not exist");
    }

}
