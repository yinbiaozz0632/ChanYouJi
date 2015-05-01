package com.qianfeng.chanyouji.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.adapter.DestinationsAdapter;
import com.qianfeng.chanyouji.beans.DestinationsDatas;
import com.qianfeng.chanyouji.netutils.DownLoadData;
import com.qianfeng.chanyouji.netutils.PaseJson;
import com.qianfeng.chanyouji.urls.FinalUrl;

import java.util.List;

/**
 * Created by admin on 2015/4/30.
 */
public class DestinationFragment extends Fragment implements PullToRefreshBase.OnRefreshListener<ListView> {
    private PullToRefreshListView pullToRefalsh;
    private List<DestinationsDatas> destinationsDatases;
    private DestinationsAdapter adapter;
    private Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1) {
                String s = (String) msg.obj;
                //解析数据
                destinationsDatases = PaseJson.jsonToList(s);
                adapter = new DestinationsAdapter(getActivity(),destinationsDatases);
                pullToRefalsh.setAdapter(adapter);

            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.destination, container, false);

        pullToRefalsh = ((PullToRefreshListView) view.findViewById(R.id.pulltolistview));
        DownLoadData.downData(getActivity(), FinalUrl.DESTINATION,handler,1);
        //下拉监听
        pullToRefalsh.setOnRefreshListener(this);
        //pullToRefalsh.getRefreshableView(); 将pulltorefalsh转成普通的listView可以添加头部

        return view;
    }

    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {
        DownLoadData.downData(getActivity(), FinalUrl.DESTINATION,handler,1);

        pullToRefalsh.onRefreshComplete();
    }

}
