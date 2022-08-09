package v1.trial.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Optional;

import v1.trial.R;
import v1.trial.controller.FrontController;
import v1.trial.usecases.user.UserFacade;

public class LoginActivity extends AppCompatActivity {
    private String username;
    private String password;
    private final FrontController frontController;

    public LoginActivity(FrontController fc) {
        this.frontController = fc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button loginButton = (Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
                EditText passwordInput = (EditText) findViewById(R.id.passwordInput);

                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();

                if(username.equals("admin") && password.equals("admin")) {
                    // get is admin
                    boolean isAdmin = true;

                    checkForAdminUser(username, password);

                    if(isAdmin) {
                        openMainMenuAdminActivity();
                    }
                    else {
                        openMainMenuBasicActivity();
                    }
                }
                else {
                    TextView printResult = findViewById(R.id.resultTestView);
                    printResult.setText(getResources().getString(R.string.loginTryAgain));
                }
            }
        });
    }

    private void openMainMenuAdminActivity() {
        Intent intent = new Intent(this, MainMenuAdminActivity.class);
        startActivity(intent);
    }

    private void openMainMenuBasicActivity() {
        Intent intent = new Intent(this, MainMenuBasicActivity.class);
        startActivity(intent);
    }

    private void checkForAdminUser(String username, String password) {
        UserFacade userFacade = new UserFacade(null, this.frontController.getUserRepository(),
                this.frontController.getWalletManager(),
                this.frontController.getArtManager());
        userFacade.login(username, password);

        setActiveUserToAdmin(userFacade);
    }

    private void setActiveUserToAdmin(UserFacade userFacade) {
        if (userFacade.getIsAdmin()) {
            this.frontController.setActiveUser(Optional.of(userFacade.createAdminFacade()));
        }
        else {
            this.frontController.setActiveUser(Optional.of(userFacade));
        }
    }
}