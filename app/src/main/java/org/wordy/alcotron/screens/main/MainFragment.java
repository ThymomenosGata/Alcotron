package org.wordy.alcotron.screens.main;

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
import android.widget.ProgressBar;

import org.wordy.alcotron.R;
import org.wordy.alcotron.screens.doing.DoingFragment;
import org.wordy.alcotron.screens.truth.TruthFragment;

public class MainFragment extends Fragment {

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    private LinearLayout mTruthContainer, mDoingContainer;
    private ProgressBar mProgress;
    private FragmentManager mFragmentManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mTruthContainer = view.findViewById(R.id.truth_main);
        mDoingContainer = view.findViewById(R.id.doing_main);
        mProgress = view.findViewById(R.id.progressBar);

        mFragmentManager = getFragmentManager();


        mTruthContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reVisible();
                loadInitialFragment(TruthFragment.newInstance());
            }
        });

        mDoingContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reVisible();
                loadInitialFragment(DoingFragment.newInstance());
            }
        });

        return view;
    }

    private void loadInitialFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(R.id.scaneRoot, fragment);
        fragmentTransaction.commit();
    }

    private void reVisible() {
        mTruthContainer.setVisibility(View.GONE);
        mDoingContainer.setVisibility(View.GONE);
        mProgress.setVisibility(View.VISIBLE);
    }

}
