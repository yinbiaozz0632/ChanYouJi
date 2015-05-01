package com.qianfeng.chanyouji.tn_viewpager_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.List;

/**
 * Created by aaa on 15-4-30.
 */
public class TNViewPagerFragment extends Fragment {
    private static List<String> urllist;
    public static TNViewPagerFragment getFragment(int position,List<String> list)
    {
        TNViewPagerFragment tnViewPagerFragment=new TNViewPagerFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("KEY",position);
        tnViewPagerFragment.setArguments(bundle);
        urllist=list;
        return tnViewPagerFragment;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view=inflater.inflate(R.layout.tn_vp_imageview,container,false);
//        ImageView iv= (ImageView) view.findViewById(R.id.iv_header);
//        int position = getArguments().getInt("KEY");
//        BitmapHelper.getBitmapUtils().display(iv,urllist.get(position));
//        return view;
    }

