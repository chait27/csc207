package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class ViewArtActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view_art);

        Button backButton = (Button) this.findViewById(R.id.backButtonToOpenWallet);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), OpenWalletActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        // IN AN ACTUAL IMPLEMENTATION USE @STRING OR SOMETHING SIMILAR TO SEND STRING DATA TO THE UI

    }
}
