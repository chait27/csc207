package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class MainMenuBasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_basic_activity);

        Button marketButton = (Button) this.findViewById(R.id.mainMenuOption1);
        Button walletButton = (Button) this.findViewById(R.id.mainMenuOption2);
        Button profileButton = (Button) this.findViewById(R.id.mainMenuOption3);
        Button logoutButton = (Button) this.findViewById(R.id.mainMenuOption4);
        Button exitButton = (Button) this.findViewById(R.id.mainMenuOption5);

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

                Intent intent = new Intent(view.getContext(), LoginActivity.class);
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
    }
}

