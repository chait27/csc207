package v1.trial.exceptions.user;

public class UserIsNotBannableException extends UsernameException {
    public UserIsNotBannableException(final String username) {
        super(username, "User %s is not bannable.");
    }
}
