package v1.trial.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import v1.trial.Main;
import v1.trial.R;

public class LoginActivity extends AppCompatActivity {
    private static String username;
    private static String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        setupLoginButton();
    }

    private void setupLoginButton() {
        Button loginButton = (Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
                EditText passwordInput = (EditText) findViewById(R.id.passwordInput);

                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();

                //Main.main();
                login();
            }
        });
    }

    private void login() {
        if(username.equals("admin")&&password.equals("admin")) {
            // check if user is admin or not
            boolean isAdmin = true;
            if(isAdmin) {
                loginSuccessAdmin();
            } else {
                loginSuccessBasic();
            }
        } else {
            retry();
        }
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void loginSuccessAdmin() {
        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
        openMainMenuAdminActivity();
    }
    public void loginSuccessBasic() {
        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
        openMainMenuBasicActivity();
    }
    public void retry() {
        Toast.makeText(LoginActivity.this, "Login Failed! Try Again.", Toast.LENGTH_SHORT).show();
    }

    private void openMainMenuAdminActivity() {
        Intent intent = MainMenuAdminActivity.makeIntent(LoginActivity.this);
        startActivity(intent);
    }

    private void openMainMenuBasicActivity() {
        Intent intent = MainMenuBasicActivity.makeIntent(LoginActivity.this);
        startActivity(intent);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }
}