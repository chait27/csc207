package v1.trial.usecases.user;

import v1.trial.databases.UserRepository;
import v1.trial.entity.markets.Wallet;
import v1.trial.entity.user.AdminUser;
import v1.trial.entity.user.BasicUser;
import v1.trial.entity.user.User;
import v1.trial.exceptions.user.UserDoesNotExistException;
import v1.trial.exceptions.user.UsernameAlreadyExistsException;
import v1.trial.factory.UserFactory;
import v1.trial.usecases.markets.WalletManager;

public class CreateUser {
    private final UserRepository userRepository;
    private final WalletManager walletManager;

    /**
     * Use-case class for creating and deleting users
     * @param userRepository an UserRepository instance
     * @param walletManager a WalletManager instance
     */
    public CreateUser(UserRepository userRepository, WalletManager walletManager) {

        this.userRepository = userRepository;
        this.walletManager = walletManager;
    }

    /**
     * Check if the provided user does not already exist, then create the user and save it into the user repository.
     * @param username username for created user.
     * @param password password for created user.
     * @param isAdmin is the user an admin user?
     * @see entity.user.User
     */
    public void createUser(final String username, final String password, final boolean isAdmin) {
        if (userRepository.getByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }
        User newUser;
        UserFactory userFactory = new UserFactory();
        if (isAdmin) {
            newUser =  userFactory.getUser(username, password, false);
        }
        else {
            newUser =  userFactory.getUser(username, password, true);
        }
        Wallet defaultWallet = walletManager.createWallet(newUser);

        userRepository.createUser(newUser);

    }

    /**
     * Check if the user exists, then remove it from the user repository. (It will still exist in memory for a given
     * session, but will not be able to be accessed by any entities/use-cases/controllers)
     * @param username username for user intended for deletion.
     */
    public void deleteUser(final String username) {
        User deletedUser = this.userRepository.getByUsername(username).orElseThrow(() -> new UserDoesNotExistException(username));
        this.userRepository.removeUser(deletedUser);
    }
}
