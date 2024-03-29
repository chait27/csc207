package v1.trial.controller;

import v1.trial.view.ProfileView;

import java.time.LocalDateTime;

public class ProfileController {

    private final ProfileView view;
    private final FrontController frontController;

    /**
     * A controller used for actions pertaining to the user's profile
     * @param frontController the FrontController instance used by this class
     */
    public ProfileController(FrontController frontController) {
        this.frontController = frontController;
        this.view = new ProfileView();
    }

    /**
     * Shows the user's profile and sends a request to get profile actions
     */
    public void viewProfile() {
        String username = this.frontController.getActiveUser().get().getUsername();
        int walletCount = this.frontController.getActiveUser().get().getNumberOfWallets();
        double netWorth = this.frontController.getActiveUser().get().getTotalNetWorth();
        LocalDateTime firstLogin = this.frontController.getActiveUser().get().getEventsByType("Login").stream().map(x -> x.getKey()).min(LocalDateTime::compareTo).orElse(null);
        this.view.showProfile(username, walletCount, netWorth, firstLogin);
        this.frontController.dispatchRequest("GET PROFILE ACTIONS");
    }
}
