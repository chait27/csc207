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
