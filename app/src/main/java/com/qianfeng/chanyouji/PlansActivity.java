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
import com.qianfeng.chanyouji.adapter.PlansAdapter;
import com.qianfeng.chanyouji.beans.PlansData;
import com.qianfeng.chanyouji.netutils.DownLoadData;
import com.qianfeng.chanyouji.netutils.PaseJson;
import com.qianfeng.chanyouji.urls.FinalUrl;

import java.util.List;


public class PlansActivity extends ActionBarActivity implements PullToRefreshBase.OnRefreshListener<ListView>{
    private PullToRefreshListView plansListView;
    private String id;
    private String name_zh_cn;
    private TextView text_Name;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            plansListView.onRefreshComplete();
            if (msg.what==1) {
                String s = (String) msg.obj;
                //解析
                List<PlansData> plansDatas = PaseJson.jsonToPlansList(s);
                //plansListView 设置适配器

                plansListView.setAdapter(new PlansAdapter(PlansActivity.this,plansDatas));
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        init();

        DownLoadData.downData(this, FinalUrl.PLANS+id+".json?page=1",handler,1);

    }
    private LinearLayout linear;
    private void init() {
        linear = ((LinearLayout) findViewById(R.id.plansback));
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        plansListView = ((PullToRefreshListView) findViewById(R.id.planslistview));
        plansListView.setOnRefreshListener(this);
        text_Name = ((TextView) findViewById(R.id.plans));
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name_zh_cn = intent.getStringExtra("name_Zh_Cn");
        text_Name.setText(name_zh_cn);
    }


    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {

    }
}
