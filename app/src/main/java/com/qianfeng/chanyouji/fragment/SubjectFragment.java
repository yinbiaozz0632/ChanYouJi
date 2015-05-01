package com.qianfeng.chanyouji.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.adapter.SubjectShouYeAdapter;
import com.qianfeng.chanyouji.beans.Subject_ShouYeData;
import com.qianfeng.chanyouji.urls.Urls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 专题首页
 *
 * Created by 程朋飞 on 2015/4/30.
 */
public class SubjectFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2<ListView>{

    private ProgressBar sub_pb;
    private View view;
    private RequestQueue requestQueue;
    private PullToRefreshListView listView;
    private List<Subject_ShouYeData> listDatas;
    private SubjectShouYeAdapter adapter;
    private int page=1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_subject_items,container,false);

        requestQueue = Volley.newRequestQueue(getActivity());
        init();
        downLoadJsonString();


        adapter = new SubjectShouYeAdapter(listDatas,getActivity());
        listView.setAdapter(adapter);


        return view;
    }

    /**
     * 初始化变量
     */
    private void init(){
        sub_pb= ((ProgressBar) view.findViewById(R.id.subject_pb));
        listView = ((PullToRefreshListView) view.findViewById(R.id.subject_ptfListView));
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(this);

        listDatas=new ArrayList<>();
    }


    /**
     * 下载Json字符串
     */

    private void downLoadJsonString(){
        JsonArrayRequest request = new JsonArrayRequest(Urls.Subject_ShouYe+page,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Subject_ShouYeData data=null;
                for(int i=0;i<jsonArray.length();i++){
                    try {
                        data=new Subject_ShouYeData();
                        JSONObject obj = (JSONObject) jsonArray.get(i);
                        data.setId(obj.getInt("id"));
                        data.setName(obj.getString("name"));
                        data.setImage_url(obj.getString("image_url"));
                        data.setTitle(obj.getString("title"));
                        data.setDestination_id(obj.getInt("destination_id"));
                        data.setUpdated_at(obj.getString("updated_at"));
                        listDatas.add(data);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
//                Log.d("bb",listDatas.toString());
                adapter.notifyDataSetChanged();
                sub_pb.setVisibility(View.GONE);
                listView.onRefreshComplete();


            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(),"数据请求失败",Toast.LENGTH_SHORT).show();
                sub_pb.setVisibility(View.GONE);
                listView.onRefreshComplete();
            }
        });
        requestQueue.add(request);
        request.setTag("TAG");
    }


    @Override
    public void onStop() {
        super.onStop();
        if (requestQueue != null) {
            requestQueue.cancelAll("TAG");
        }
    }

    /**
     * 上拉和下拉的监听事件
     * @param refreshView
     */
    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        page=1;
        listDatas.clear();
        adapter.notifyDataSetChanged();
        downLoadJsonString();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        page++;
        downLoadJsonString();
    }
}
