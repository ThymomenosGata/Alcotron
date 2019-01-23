package org.wordy.alcotron.screens.i_never;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class INeverFragment extends Fragment implements INeverContract.View {

    private INeverModel model;
    private INeverPresenter presenter;

    private TextView mTextNever;
    private LinearLayout buttonNever;

    private SharedPreferences mFlags;
    private SharedPreferences.Editor editor;
    public static final String APP_PREFERENCES = "myFlags";
    public static final String APP_PREFERENCES_ADS = "Ads";
    private int ads_count;

    private InterstitialAd mInterstitialAd;

    public INeverFragment() {
    }

    public static INeverFragment newInstance() {
        return new INeverFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inever, container, false);

        MobileAds.initialize(getActivity(), "ca-app-pub-8292159750506516~6181036832");
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.test_ads));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        mTextNever = view.findViewById(R.id.i_never_text);
        buttonNever = view.findViewById(R.id.button_never);

        model = new INeverModel();
        presenter = new INeverPresenter(model, this);

        presenter.setTextTask();

        mFlags = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ads_count = mFlags.getInt(APP_PREFERENCES_ADS, 0);

        buttonNever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ads_count < 10) {
                    updateAdsFlag();
                    presenter.setTextTask();
                } else {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd.show();
                    }
                    navigateBeforeAds();
                }
            }
        });

        return view;
    }

    public void setTextNever(String text) {
        mTextNever.setText(text);
    }

    public void setAdsCount(int ads_count) {
        editor = mFlags.edit();
        editor.putInt(APP_PREFERENCES_ADS, ads_count);
        editor.apply();
    }

    public void updateAdsFlag() {
        ads_count++;
        setAdsCount(ads_count);
    }

    public void navigateBeforeAds() {
        ads_count = 0;
        if (!mInterstitialAd.isLoaded()) {
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
        setAdsCount(ads_count);
        presenter.setTextTask();
    }
}
