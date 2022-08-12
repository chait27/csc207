package v1.trial.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import v1.trial.R;

public class MainMenuAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_admin_activity);

        Button marketButton = (Button) this.findViewById(R.id.Option1);
        Button walletButton = (Button) this.findViewById(R.id.Option2);
        Button profileButton = (Button) this.findViewById(R.id.Option3);
        Button logoutButton = (Button) this.findViewById(R.id.Option5);
        Button exitButton = (Button) this.findViewById(R.id.Option6);
        Button adminButton = (Button) this.findViewById(R.id.Option4);

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MarketActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        walletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WalletActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Logout User

                Intent intent = new Intent(view.getContext(), SetupActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Save application info then exist app

                finish();
                System.exit(0);
            }
        });

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AdminActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MainMenuAdminActivity.class);
    }
}
