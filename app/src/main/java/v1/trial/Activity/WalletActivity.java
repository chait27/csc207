package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class WalletActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet_activity);

        Button viewWalletButton = (Button) this.findViewById(R.id.Option1);
        Button createWalletButton = (Button) this.findViewById(R.id.Option2);
        Button backButton = (Button) this.findViewById(R.id.Option3);

        viewWalletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display user's wallets

            }
        });

        viewWalletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent;
                intent.putExtra("walletID", wallet);
                intent = new Intent(view.getContext(), WalletActivity.class);

            }
        });

    }
}
