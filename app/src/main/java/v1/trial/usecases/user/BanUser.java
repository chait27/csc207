package v1.trial.usecases.user;

import v1.trial.databases.UserRepository;
import v1.trial.entity.user.BasicUser;
import v1.trial.entity.user.User;
import v1.trial.exceptions.user.UserDoesNotExistException;
import v1.trial.exceptions.user.UserIsNotBannableException;
import v1.trial.interfaces.IBannableUser;

import java.time.LocalDateTime;

public class BanUser {
    private final UserRepository userRepository;

    /**
     * Use-cass class for banning users.
     * @param userRepository an UserRepository instance
     */
    public BanUser(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    /**
     * Ban a user until a specified date-time, if the user is bannable (implements the IBannable interface), otherwise
     * throw an exception.
     * @param username username of user intended for banning.
     * @param banUntil ban the user until the date-time banUntil.
     */
    public void banUser(final String username, final LocalDateTime banUntil) {
        User bannedUser = this.userRepository.getByUsername(username).orElseThrow(() -> new UserDoesNotExistException(username));
        if (!(bannedUser instanceof IBannableUser)) {
            throw new UserIsNotBannableException(username);
        }
        ((BasicUser) bannedUser).setTempBannedUntil(banUntil);
        bannedUser.setLoggedIn(false);
    }
}
