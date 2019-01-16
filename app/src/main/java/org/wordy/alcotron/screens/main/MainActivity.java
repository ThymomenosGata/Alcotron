package org.wordy.alcotron.screens.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.wordy.alcotron.R;
import org.wordy.alcotron.screens.doing.DoingFragment;
import org.wordy.alcotron.screens.i_never.INeverFragment;
import org.wordy.alcotron.screens.truth.TruthFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private SharedPreferences mFlags;
    public static final String APP_PREFERENCES = "myFlags";
    public static final String APP_PREFERENCES_FLAG = "Flag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFlags = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        int flag = -1;

        if(mFlags.contains(APP_PREFERENCES_FLAG)) {
            flag = mFlags.getInt(APP_PREFERENCES_FLAG, -1);
        }

        mFragmentManager = getSupportFragmentManager();

        if (flag == -1) {
            return;
        } else if (flag == 0) {
            loadInitialFragment(MainFragment.newInstance());
        } else if (flag == 1) {
            loadInitialFragment(DoingFragment.newInstance());
        } else if (flag == 2) {
            loadInitialFragment(TruthFragment.newInstance());
        } else if (flag == 3) {
            loadInitialFragment(INeverFragment.newInstance());
        }
    }

    private void loadInitialFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.scaneRoot, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
