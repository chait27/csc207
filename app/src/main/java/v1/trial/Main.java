package v1.trial;

import v1.trial.controller.FrontController;
import v1.trial.utils.Config;

public class Main {
    public static void main(String[] args) {
        Config config = new Config("storage/",
                                   "basicUsers.csv",
                                   "adminUsers.csv",
                                   "events.csv",
                                   "wallets.csv",
                                   "asciiArts.csv");


        FrontController controller = new FrontController(config);
        controller.dispatchRequest("LOGIN");
    }
}

