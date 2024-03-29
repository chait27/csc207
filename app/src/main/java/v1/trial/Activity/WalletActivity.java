package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class WalletActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet_activity);

        Button viewWalletButton = (Button) this.findViewById(R.id.Option1);
        Button createWalletButton = (Button) this.findViewById(R.id.WalletOption2);
        Button backButton = (Button) this.findViewById(R.id.Option3);

        viewWalletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display user's wallets if available
                Intent intent = new Intent(view.getContext(), BrowseWalletsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        createWalletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = new Intent(view.getContext(), CreateWalletActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check user is admin/basic
                boolean isAdmin = true;
                Intent intent;
                if(isAdmin) {
                    intent = new Intent(view.getContext(), MainMenuAdminActivity.class);
                } else {
                    intent = new Intent(view.getContext(), MainMenuBasicActivity.class);
                }
                view.getContext().startActivity(intent);

            }
        });

    }
}
