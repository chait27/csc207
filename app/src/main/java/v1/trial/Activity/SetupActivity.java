package v1.trial.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import v1.trial.R;
import v1.trial.controller.FrontController;
import v1.trial.utils.Config;

public class SetupActivity extends AppCompatActivity {
    private static FrontController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_activity);

        Config config = new Config("./storage/",
                "basicUsers.csv",
                "adminUsers.csv",
                "events.csv",
                "wallets.csv",
                "asciiArts.csv");

        this.controller = new FrontController(config);
        // controller.dispatchRequest("LOGIN");

        launchLogin();
    }

    private void launchLogin() {
        Intent intent = LoginActivity.makeIntent(LoginActivity.this);
        startActivity(intent);
    }
}