package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        Button viewProfileButton = (Button) this.findViewById(R.id.Option1);
        Button usernameButton = (Button) this.findViewById(R.id.Option2);
        Button passwordButton = (Button) this.findViewById(R.id.Option3);
        Button backButton = (Button) this.findViewById(R.id.Option4);

        viewProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display profile
            }
        });

        usernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change username
            }
        });

        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change password
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if logged on user is admin/basic
                boolean isAdmin = true;

                Intent intent;
                if (isAdmin) {
                    intent = new Intent(view.getContext(), MainMenuAdminActivity.class);
                } else {
                    intent = new Intent(view.getContext(), MainMenuBasicActivity.class);
                }
                view.getContext().startActivity(intent);
            }
        });
    }
}
