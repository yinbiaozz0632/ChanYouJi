package com.qianfeng.chanyouji;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.chanyouji.adapter.TripsItemAdapter;
import com.qianfeng.chanyouji.beans.TripsData;
import com.qianfeng.chanyouji.netutils.DownLoadData;
import com.qianfeng.chanyouji.netutils.PaseJson;
import com.qianfeng.chanyouji.urls.FinalUrl;

import java.util.ArrayList;
import java.util.List;


public class TripsActivity extends ActionBarActivity implements PullToRefreshBase.OnRefreshListener2<ListView> {
    private PullToRefreshListView plansListView;
    private String id;
    private String name_zh_cn;
    private TextView text_Name;
    private static int  pageIndex=1;
    private TripsItemAdapter adapter;
    private static List<TripsData> list;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            plansListView.onRefreshComplete();
            if (msg.what==1) {
                String s = (String) msg.obj;
                //解析
                List<TripsData> tripsDatas = PaseJson.jsonToTripsDataList(s);
                //设置适配器
                list.clear();
                list.addAll(tripsDatas);
                plansListView.setAdapter(adapter);

            }else if (msg.what==2){
                String s = (String) msg.obj;
                //解析
                List<TripsData> tripsDatas = PaseJson.jsonToTripsDataList(s);
                list.addAll(tripsDatas);
                plansListView.setAdapter(adapter);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        init();
        //下载数据

        DownLoadData.downData(this, FinalUrl.TRIPS+id+".json?page="+1,handler,1);


    }

    private LinearLayout linear;

    private void init() {
        list=new ArrayList<>();
        adapter=new TripsItemAdapter(this,list);
        linear = ((LinearLayout) findViewById(R.id.plansback));
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        plansListView = ((PullToRefreshListView) findViewById(R.id.planslistview));
        plansListView.setMode(PullToRefreshBase.Mode.BOTH);
        plansListView.setOnRefreshListener(this);
        text_Name = ((TextView) findViewById(R.id.plans));
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name_zh_cn = intent.getStringExtra("name_Zh_Cn");
        text_Name.setText(name_zh_cn);
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        //下来刷新
        DownLoadData.downData(this, FinalUrl.TRIPS+id+".json?page="+1,handler,1);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
      //上拉加载
        pageIndex++;
        DownLoadData.downData(this, FinalUrl.TRIPS+id+".json?page="+pageIndex,handler,2);

    }
}
