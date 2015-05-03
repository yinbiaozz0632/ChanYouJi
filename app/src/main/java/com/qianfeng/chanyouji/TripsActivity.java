package com.qianfeng.chanyouji;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
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


public class TripsActivity extends ActionBarActivity implements PullToRefreshBase.OnRefreshListener2<ListView>, AdapterView.OnItemSelectedListener {
    private PullToRefreshListView plansListView;
    private String id;
    private static String month="";
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
                adapter.notifyDataSetChanged();

            }else if (msg.what==2){
                //上拉加载
                String s = (String) msg.obj;
                //解析
                List<TripsData> tripsDatas = PaseJson.jsonToTripsDataList(s);
                list.addAll(tripsDatas);
                adapter.notifyDataSetChanged();
            }else if (msg.what==3){
                list.clear();
                String s=((String) msg.obj);
                List<TripsData> tripsDatas = PaseJson.jsonToTripsDataList(s);
                list.addAll(tripsDatas);
                adapter.notifyDataSetChanged();
            }
        }
    };
    private Spinner spinner_Seasons,spinner_Moods;

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
        ArrayList<String> strings = new ArrayList<>();
        strings.add("季节");
        strings.add("1月");
        strings.add("2月");
        strings.add("3月");
        strings.add("4月");
        strings.add("5月");
        strings.add("6月");
        strings.add("7月");
        strings.add("8月");
        strings.add("9月");
        strings.add("10月");
        strings.add("11月");
        strings.add("12月");

        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("人气");
        strings1.add("最新");

        list=new ArrayList<>();
        adapter=new TripsItemAdapter(this,list);

        View view = View.inflate(this, R.layout.headeritem, null);
        spinner_Seasons = ((Spinner) view.findViewById(R.id.spinner1));
        spinner_Moods = ((Spinner) view.findViewById(R.id.spinner2));

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, strings);

        spinner_Seasons.setAdapter(adapter1);

        //给spinner做监听
        spinner_Seasons.setOnItemSelectedListener(this);
        spinner_Moods.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,strings1));
        spinner_Moods.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        linear = ((LinearLayout) findViewById(R.id.plansback));
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        plansListView = ((PullToRefreshListView) findViewById(R.id.planslistview));
        plansListView.setMode(PullToRefreshBase.Mode.BOTH);
        plansListView.setAdapter(adapter);
        ListView refreshableView = plansListView.getRefreshableView();
        refreshableView.addHeaderView(view);
        plansListView.setOnRefreshListener(this);
        text_Name = ((TextView) findViewById(R.id.plans));
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name_zh_cn = intent.getStringExtra("name_Zh_Cn");
        text_Name.setText(name_zh_cn);
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        //DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+"&month=1",handler,3);
        //下来刷新
        DownLoadData.downData(this, FinalUrl.TRIPS+id+".json?page="+1+month,handler,1);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
      //上拉加载
        pageIndex++;
        DownLoadData.downData(this, FinalUrl.TRIPS+id+".json?page="+pageIndex+month,handler,2);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id1) {
       switch (position){
           case 0:
               plansListView.setAdapter(adapter);
               break;
           case 1:
               list.clear();
               //"https://chanyouji.com/api/destinations/trips/55.json?page=1&month=1"month="&month=1"
               month="&month=1";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 2:
               month="&month=2";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 3:
               month="&month=3";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 4:
               month="&month=4";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 5:
               month="&month=5";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 6:
               month="&month=6";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 7:
               month="&month=7";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 8:
               month="&month=8";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 9:
               month="&month=9";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 10:
               month="&month=10";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 11:
               month="&month=11";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
           case 12:
               month="&month=12";
               DownLoadData.downData(TripsActivity.this,FinalUrl.TRIPS+id+".json?page="+1+month,handler,3);
               break;
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
