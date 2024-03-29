package v1.trial.controller;

import v1.trial.exceptions.market.WalletNotFoundException;
import v1.trial.usecases.art.ArtGenerator;
import v1.trial.usecases.art.ArtManager;
import v1.trial.usecases.markets.WalletFacade;
import v1.trial.usecases.markets.WalletManager;
import v1.trial.view.WalletView;

import java.io.IOException;
import java.util.UUID;

// this class might be overstepping the controller bounds

public class WalletController {

    private final FrontController frontController;
    private final WalletManager walletManager;
    private WalletFacade wallet;
    private final WalletView view;
    private final ArtManager artManager;

    /**
     * Controller used for wallet related tasks.
     * @param frontController the FrontController instance used by this class
     */
    public WalletController(FrontController frontController) {
        this.frontController = frontController;
        this.walletManager = this.frontController.getWalletManager();
        this.artManager = this.frontController.getArtManager();
        this.view = new WalletView();
    }

    /**
     * Retrieve a wallet facade object using the wallet's UUID
     * @param walletID the UUID of the target wallet
     */
    public void retrieveWallet(UUID walletID) {
        try {
            this.wallet = new WalletFacade(null, this.walletManager, this.artManager);
            this.wallet.initializeWalletByID(this.frontController.getActiveUser().get().getUsername(), walletID);
        } catch (WalletNotFoundException e) {
            this.view.showErrorMessage(e.getMessage());
        }
    }

    /**
     * Show the liquidity of the wallet to the user
     * @param walletID the ID of the target wallet
     */
    public void viewLiquidity(UUID walletID) {
        this.retrieveWallet(walletID);
        this.view.showLiquidity(wallet.getCurrency());
        this.frontController.dispatchRequest("GET WALLET ACTIONS", walletID);
    }

    /**
     * Show the liquidity of the wallet to the user
     * @param walletID the ID of the target wallet
     */
    public void viewWalletWorth(UUID walletID) {
        this.retrieveWallet(walletID);
        this.view.showWalletWorth(wallet.getNetWorth());
        this.frontController.dispatchRequest("GET WALLET ACTIONS", walletID);
    }
    /**
     * Makes a request to get wallet actions
     * @param walletID the ID of the target wallet
     */
    public void viewWalletArt(UUID walletID) {
        this.retrieveWallet(walletID);
        this.view.showWalletGallery(this.wallet.getWalletArts(), this.wallet.getWalletArtTitles(), this.wallet.getWalletArtPrices());
        this.frontController.dispatchRequest("GET WALLET ACTIONS", walletID);
    }

    /**
     * Creates a new wallet
     */
    public void createWallet() {
        this.view.showWalletNamePrompt();
        String walletName = this.frontController.userInput.nextLine();
        this.view.showPublicAccessPrompt(walletName);
        String isPublicString = this.frontController.userInput.nextLine();
        if (!(isPublicString.equals("y") || isPublicString.equals("n"))) {
            this.view.showErrorMessage("Answer must be in (y/n)");
            this.frontController.dispatchRequest("SELECT WALLET");
        } else {
            boolean isPublic = isPublicString.equals("y");
            this.frontController.getActiveUser().get().addWallet(walletName, isPublic);
            this.view.showCreateWalletSuccess(walletName);
            this.frontController.dispatchRequest("SELECT WALLET");
        }
    }

    /**
     * create a new piece of art and adds it to the system
     * @param walletID the id of wallet where the new art will be located
     */
    public void mintArt(UUID walletID) {
        this.retrieveWallet(walletID);
        this.view.showArtPrompt();
        String artPrompt = this.frontController.userInput.nextLine();
        try {
            ArtGenerator artGenerator = new ArtGenerator();
            String generatedArt = artGenerator.generateArt(artPrompt);
            this.view.showArt(generatedArt);
            this.view.showSetPricePrompt(artPrompt);
            String price = this.frontController.userInput.nextLine();
            try {
                float priceDouble = Float.parseFloat(price);
                this.artManager.createNewArt(artPrompt, generatedArt, priceDouble, walletID);
                this.view.showMintSuccess(artPrompt, priceDouble);
            } catch (NumberFormatException e) {
                this.view.showErrorMessage("Input the price as a number and try again");
                this.frontController.dispatchRequest("GET WALLET ACTIONS", walletID);
            }
            this.frontController.dispatchRequest("GET WALLET ACTIONS", walletID);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
