package v1.trial.usecases.user;

import v1.trial.databases.UserRepository;
import v1.trial.entity.art.Art;
import v1.trial.entity.user.User;
import v1.trial.exceptions.user.UserDoesNotExistException;
import v1.trial.usecases.art.ArtManager;
import v1.trial.usecases.markets.WalletManager;

import java.util.ArrayList;
import java.util.List;

public class FindUser {
    private final UserRepository userRepository;
    private final WalletManager walletManager;

    /**
     * Find a user from the repository
     * @param userRepository an UserRepository instance
     * @param walletManager a WalletManager instance
     */
    public FindUser(UserRepository userRepository, WalletManager walletManager) {
        this.userRepository = userRepository;
        this.walletManager = walletManager;
    }

    /**
     * Get a specific user by their username
     * @param username String of the target user's username
     * @return the User object with said name
     */
    public User getUserByUsername (String username) {
        return this.userRepository.getByUsername(username).orElseThrow(() -> new UserDoesNotExistException(username));
    }
}
