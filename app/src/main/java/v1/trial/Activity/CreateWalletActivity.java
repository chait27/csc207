package v1.trial.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;


import v1.trial.R;

public class CreateWalletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_wallet);


        prepareWalletCreationButton();
    }

    private void prepareWalletCreationButton(){
        Button confirmCreation = (Button) this.findViewById(R.id.createWalletButton);

        confirmCreation.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   EditText walletName = (EditText) findViewById(R.id.editTextWalletName);
                   Switch privateSwitch = (Switch) findViewById(R.id.walletPrivateSwitch);
                   String walletIsPrivate;
                   if (privateSwitch.isChecked()){
                       walletIsPrivate = "private";
                   } else {
                       walletIsPrivate = "public";
                   }

                   Toast.makeText(CreateWalletActivity.this, "Created " + walletIsPrivate + " wallet \"" + walletName, Toast.LENGTH_LONG);
               }
           }
        );
    }

}