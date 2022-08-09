package v1.trial.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import v1.trial.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
                EditText passwordInput = (EditText) findViewById(R.id.passwordInput);

                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if(username.equals("admin") && password.equals("admin")) {
                    // get is admin
                    boolean isAdmin;

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
}