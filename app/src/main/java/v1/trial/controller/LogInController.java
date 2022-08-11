package v1.trial.controller;

import v1.trial.Activity.LoginActivity;
import v1.trial.exceptions.user.IncorrectUserNameOrPasswordException;
import v1.trial.exceptions.user.UserIsBannedException;
import v1.trial.usecases.user.UserFacade;

import java.util.Optional;

public class LogInController {
    private final FrontController frontController;
    private final LoginActivity activity;

    /**
     * The controller responsible for logging a user in and out
     * @param frontController the FrontController instance that will be used
     */
    public LogInController (FrontController frontController) {
        this.frontController = frontController;
        this.activity = new LoginActivity();
    }

    /**zz
     * logs the user in
     */
    public void login() {
        String username = this.activity.getUsername();
        String password = this.activity.getPassword();

        if(checkForUser(username, password)) {
            this.frontController.dispatchRequest("GET MAIN ACTIONS");
        }
        else {
            this.activity.retry();
        }
    }

    private boolean checkForUser(String username, String password) {
        UserFacade userFacade = new UserFacade(null, this.frontController.getUserRepository(),
                                                          this.frontController.getWalletManager(),
                                                          this.frontController.getArtManager());

        if(userFacade.login(username, password)) {
            if(userFacade.getIsAdmin()) {
                this.activity.loginSuccessAdmin();
                this.frontController.setActiveUser(Optional.of(userFacade.createAdminFacade()));
            } else {
                this.activity.loginSuccessBasic();
                this.frontController.setActiveUser(Optional.of(userFacade));
            }
            return true;
        }
        return false;
    }

    /**
     * logs the user out
     */
    public void logout () {
        if (frontController.getActiveUser().isPresent()) {
            frontController.getActiveUser().get().logOut();
        }
        frontController.setActiveUser(Optional.empty());
        frontController.dispatchRequest("LOGIN");
    }
}
