package com.qianfeng.chanyouji.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.finalutils.FinalUrl;
import com.qianfeng.chanyouji.netutils.DownLoadData;

/**
 * Created by admin on 2015/4/30.
 */
public class DestinationFragment extends Fragment implements PullToRefreshBase.OnRefreshListener<ListView> {
    private PullToRefreshListView pullToRefalsh;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1) {
                String s = (String) msg.obj;
                //解析数据



            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImageView img=new ImageView(getActivity());
        View view = inflater.inflate(R.layout.destination, container, false);
        pullToRefalsh = ((PullToRefreshListView) view.findViewById(R.id.pulltolistview));
        DownLoadData.downData(getActivity(), FinalUrl.DESTINATION,handler,1);
        //下拉监听
        pullToRefalsh.setOnRefreshListener(this);


        return view;
    }

    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {



        pullToRefalsh.onRefreshComplete();
    }
}
