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
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.wordy.alcotron.R;
import org.wordy.alcotron.screens.main.MainFragment;

public class DoingFragment extends Fragment implements DoingContract.View {

    private DoingPresenter presenter;
    private DoingModel model;

    private LinearLayout mTruthContainer;
    private FragmentManager mFragmentManager;

    private TextView mAction;

    private SharedPreferences mFlags;
    private SharedPreferences.Editor editor;
    public static final String APP_PREFERENCES = "myFlags";
    public static final String APP_PREFERENCES_FLAG = "Flag";
    public static final String APP_PREFERENCES_ADS = "Ads";
    private int ads_count;
    private int flag;

    private InterstitialAd mInterstitialAd;

    public DoingFragment() {
    }

    public static DoingFragment newInstance() {
        return new DoingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doing, container, false);

        MobileAds.initialize(getActivity(), "ca-app-pub-8292159750506516~6181036832");
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.ads_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        model = new DoingModel();
        presenter = new DoingPresenter(model, this);

        mAction = view.findViewById(R.id.text);

        presenter.setTextTask();

        mTruthContainer = view.findViewById(R.id.truth_main);
        mFragmentManager = getFragmentManager();

        mFlags = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        flag = -1;
        ads_count = mFlags.getInt(APP_PREFERENCES_ADS, 0);

        if (mFlags.contains(APP_PREFERENCES_FLAG)) {
            flag = mFlags.getInt(APP_PREFERENCES_FLAG, -1);
        }

        mTruthContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ads_count < 6) {
                    updateAdsFlag();
                    navigateAfterAds();
                } else {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        navigateBeforeAds();
                    } else {
                        navigateBeforeAds();
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void loadInitialFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        fragmentTransaction.replace(R.id.scaneRoot, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void setTextAction(String task) {
        mAction.setText(task);
    }

    public void setAdsCount(int ads_count) {
        editor = mFlags.edit();
        editor.putInt(APP_PREFERENCES_ADS, ads_count);
        editor.apply();
    }

    public void navigateBeforeAds() {
        ads_count = 0;
        setAdsCount(ads_count);
        navigateAfterAds();
    }

    public void navigateAfterAds() {
        if (flag == 0) {
            presenter.navigateToMainFragment(MainFragment.newInstance());
        } else if (flag == 1) {
            presenter.setTextTask();
        }
    }

    public void updateAdsFlag() {
        ads_count++;
        setAdsCount(ads_count);
    }
}
