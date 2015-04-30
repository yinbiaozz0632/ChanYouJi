package com.qianfeng.chanyouji.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qianfeng.chanyouji.R;

/**
 * Created by admin on 2015/4/30.
 */
public class DestinationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImageView img=new ImageView(getActivity());

        img.setImageResource(R.drawable.ic_order_cal);

        return img;
    }
}
