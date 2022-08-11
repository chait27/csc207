package v1.trial.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import v1.trial.Main;
import v1.trial.R;

public class LoginActivity extends AppCompatActivity {
    private String username;
    private String password;

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

                Main.main();
            }
        });
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
}