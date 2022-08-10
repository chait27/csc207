package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class PersonalWalletActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_wallet_activity);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String walletName = extras.getString("walletID");

        }

        Button liquidityButton = (Button) this.findViewById(R.id.Option1);
        Button viewArtButton = (Button) this.findViewById(R.id.Option2);
        Button viewWorthButton = (Button) this.findViewById(R.id.Option3);
        Button makeArtButton = (Button) this.findViewById(R.id.Option4);
        Button backButton = (Button) this.findViewById(R.id.Option5);

        liquidityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate Worth
                String worth = "";

                TextView printResult = findViewById(R.id.resultTestView);
                printResult.setText(worth);
            }
        });

        viewWorthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate Worth
                String worth = "";

                TextView printResult = findViewById(R.id.resultTestView);
                printResult.setText(worth);
            }
        });

        makeArtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create art

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(view.getContext(), WalletActivity.class);
            }
        });

        viewArtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get art(s)
                String art = "";

                TextView printResult = findViewById(R.id.resultTestView);
                printResult.setText(art);
            }
        });
    }

}
