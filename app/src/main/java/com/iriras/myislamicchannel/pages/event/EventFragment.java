package com.iriras.myislamicchannel.pages.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iriras.myislamicchannel.R;

/**
 * Created by irfan on 25/02/17.
 */

public class EventFragment extends Fragment {
    public static EventFragment newInstance() {

        Bundle args = new Bundle();

        EventFragment fragment = new EventFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.event_fragment, container, false);
        return mView;
    }
}
