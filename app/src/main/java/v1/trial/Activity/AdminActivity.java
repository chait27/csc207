package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class AdminActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        Button userButton = (Button) this.findViewById(R.id.Option1);
        Button delUserButton = (Button) this.findViewById(R.id.Option2);
        Button addUserButton = (Button) this.findViewById(R.id.Option3);
        Button banUserButton = (Button) this.findViewById(R.id.Option4);
        Button unbanUserButton = (Button) this.findViewById(R.id.Option5);
        Button backButton = (Button) this.findViewById(R.id.Option6);

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create string of all users
                String users = "";

                TextView printResult = findViewById(R.id.resultTestView);
                printResult.setText(users);
            }
        });

        delUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // delete given user

            }
        });

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add an user

            }
        });

        banUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ban given user

            }
        });

        unbanUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // unban given user

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenuAdminActivity();
            }
        });
    }

    private void openMainMenuAdminActivity() {
        Intent intent = new Intent(this, MainMenuAdminActivity.class);
        startActivity(intent);
    }
}
