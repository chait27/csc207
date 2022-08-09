package v1.trial.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class MarketActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_activity);

        Button viewMarketButton = (Button) this.findViewById(R.id.Option1);
        Button putMarketButton = (Button) this.findViewById(R.id.Option2);
        Button makeTradeButton = (Button) this.findViewById(R.id.Option3);
        Button backButton = (Button) this.findViewById(R.id.Option4);

        viewMarketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display art available on market
            }
        });

        putMarketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // put art on market
            }
        });

        makeTradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // make trade
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
