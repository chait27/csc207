package v1.trial.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import v1.trial.R;
//import v1.trial.Activity.databinding.ActivityBrowseWalletsBinding;

public class BrowseWalletsActivity extends AppCompatActivity {

//    private ActivityBrowseWalletsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_wallets);

        createViewWalletButton();
        createCreateWalletButton();
    }

    private void createViewWalletButton(){
        Button viewButton = (Button) findViewById(R.id.OpenWalletButton);

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // opens a openWalletActivity
            }
        });
    }

    private void createCreateWalletButton(){
        Button createWalletButton = (Button) findViewById(R.id.OpenWalletButton);

        createWalletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateWalletActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

}