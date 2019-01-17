package org.wordy.alcotron.screens.i_never;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.wordy.alcotron.R;

public class INeverFragment extends Fragment implements INeverContract.View {

    private INeverModel model;
    private INeverPresenter presenter;

    private TextView mTextNever;
    private LinearLayout buttonNever;

    public INeverFragment() {
    }

    public static INeverFragment newInstance() {
        return new INeverFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inever, container, false);

        mTextNever = view.findViewById(R.id.i_never_text);
        buttonNever = view.findViewById(R.id.button_never);

        model = new INeverModel();
        presenter = new INeverPresenter(model, this);

        buttonNever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setTextTask();
            }
        });

        return view;
    }

    public void setTextNever(String text) {
        mTextNever.setText(text);
    }
}
