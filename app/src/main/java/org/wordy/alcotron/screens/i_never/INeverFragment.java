package org.wordy.alcotron.screens.i_never;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.wordy.alcotron.R;

public class INeverFragment extends Fragment {

    public INeverFragment() {
    }

    public static INeverFragment newInstance() {
        return new INeverFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inever, container, false);

        return view;
    }
}
