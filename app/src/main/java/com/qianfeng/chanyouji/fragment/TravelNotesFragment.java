package com.qianfeng.chanyouji.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.adapter.TravelNotesListAdapter;
import com.qianfeng.chanyouji.beans.TravelNotesInfo;
import com.qianfeng.chanyouji.netutils.BitmapHelper;
import com.qianfeng.chanyouji.urls.TravelNotesUrls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 2015/4/30.
 */
public class TravelNotesFragment extends Fragment {

    private ListView listView;
    private ViewPager viewPager;
    private ProgressBar pb;

    private List<ImageView> imgvs;//用于存放头部的对象
    private RequestQueue queue;
    private TravelNotesListAdapter adapter;

    private List<TravelNotesInfo> tnInfos;
    private PullToRefreshListView PTRlistView;
    private int page=1;
    private int i=0;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_travelnotes,container,false);
        View view_vp=inflater.inflate(R.layout.viewpager_travelnotes,null);
        queue=Volley.newRequestQueue(getActivity());

        tnInfos=new ArrayList<TravelNotesInfo>();

        PTRlistView= (PullToRefreshListView) view.findViewById(R.id.lv_refresh);
        PTRlistView.setMode(PullToRefreshBase.Mode.BOTH);
        PTRlistView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                tnInfos.clear();
                adapter.notifyDataSetChanged();
                getListViewData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                getListViewData();
            }
        });
         viewPager = (ViewPager) view_vp.findViewById(R.id.vp_travelnotes);
        pb= (ProgressBar) view.findViewById(R.id.pb_travelnotes);

        PTRlistView.setMode(PullToRefreshBase.Mode.BOTH);
        listView=PTRlistView.getRefreshableView();
        listView.addHeaderView(view_vp);

        getList();
        getListViewData();
        adapter=new TravelNotesListAdapter(getActivity(),tnInfos);
        PTRlistView.setAdapter(adapter);


        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);//两秒后发送消息切换vp的图片
            }
        },0,2000);


        return view;
    }


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                viewPager.setCurrentItem(i % 6);
                i++;
            }
        }
    };



    /**ViewPager头部的适配器*/
    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imgvs.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            container.addView(imgvs.get(position));
            return imgvs.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//			super.destroyItem(container, position, object);
            container.removeView(imgvs.get(position));

        }

    }

    //下载JSON字符串下载头部viewpager的头部
    public void getList()
    {
        JsonArrayRequest request = new JsonArrayRequest(TravelNotesUrls.header_url,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                imgvs=new ArrayList<ImageView>();
                for(int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        ImageView img=new ImageView(getActivity());
                        img.setScaleType(ImageView.ScaleType.FIT_XY);
                        BitmapHelper.getBitmapUtils().display(img,obj.getString("image_url"));
                        imgvs.add(img);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                viewPager.setAdapter(new ViewPagerAdapter());

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(),"请求失败",Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }



    //下载listView数据

    private void getListViewData(){
        JsonArrayRequest request1 = new JsonArrayRequest(TravelNotesUrls.TravelNotes_url+page,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

//                Log.d("Tag",jsonArray.toString());


               // tnInfos=new ArrayList<TravelNotesInfo>();
                for(int i=0;i<jsonArray.length();i++)
                {
                    try {
                        JSONObject obj=jsonArray.getJSONObject(i);
                        String front_cover_photo_url=obj.getString("front_cover_photo_url");
                        String name=obj.getString("name");
                        String start_date=obj.getString("start_date");
                        int days=obj.getInt("days");
                        int photos_count=obj.getInt("photos_count");
                        Boolean featured=obj.getBoolean("featured");
                        String image=obj.getJSONObject("user").getString("image");
                        TravelNotesInfo tnInfo=new TravelNotesInfo(front_cover_photo_url,name,start_date,days,photos_count,featured,image);
                         tnInfos.add(tnInfo);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
                PTRlistView.onRefreshComplete();
                pb.setVisibility(View.GONE);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(),"数据请求失败",Toast.LENGTH_SHORT).show();
                PTRlistView.onRefreshComplete();
                pb.setVisibility(View.GONE);
            }
        });

        queue.add(request1);
    }

}
