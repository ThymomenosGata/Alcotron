package org.wordy.alcotron.screens.doing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.wordy.alcotron.R;
import org.wordy.alcotron.screens.main.MainFragment;

public class DoingFragment extends Fragment {

    private LinearLayout mTruthContainer;
    private FragmentManager mFragmentManager;

    private SharedPreferences mFlags;
    public static final String APP_PREFERENCES = "myFlags";
    public static final String APP_PREFERENCES_FLAG = "Flag";

    public DoingFragment() {
    }

    public static DoingFragment newInstance() {
        return new DoingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doing, container, false);

        mTruthContainer = view.findViewById(R.id.truth_main);
        mFragmentManager = getFragmentManager();

        mFlags = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        int flag = -1;

        if (mFlags.contains(APP_PREFERENCES_FLAG)) {
            flag = mFlags.getInt(APP_PREFERENCES_FLAG, -1);
        }

        if (flag == 0) {
            mTruthContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadInitialFragment(MainFragment.newInstance());
                }
            });
        } else if (flag == 1) {
            mTruthContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        return view;
    }

    private void loadInitialFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        fragmentTransaction.replace(R.id.scaneRoot, fragment);
        fragmentTransaction.commit();
    }
}