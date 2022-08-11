package v1.trial.Activity;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import v1.trial.R;
import v1.trial.Activity.databinding.ActivityBrowseWalletsBinding;

public class BrowseWalletsActivity extends AppCompatActivity {

//    private ActivityBrowseWalletsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = ActivityBrowseWalletsBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        Toolbar toolbar = binding.toolbar;
//        setSupportActionBar(toolbar);
//        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
//        toolBarLayout.setTitle(getTitle());
//
//        FloatingActionButton fab = binding.fab;
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // method that shows the wallets this user possesses
    }

    // each wallet entry in the scrolling list is also a button that leads them to a wallet activity intent

}