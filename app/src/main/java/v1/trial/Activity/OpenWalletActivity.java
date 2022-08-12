package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import v1.trial.R;

public class OpenWalletActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_open_wallet);

        Button openArt = (Button) this.findViewById(R.id.viewArtButton);

        openArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), ViewArtActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}
