package com.qianfeng.chanyouji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.SearchDetailsActivity;
import com.qianfeng.chanyouji.adapter.SearchAdapter;
import com.qianfeng.chanyouji.beans.SearchData;
import com.qianfeng.chanyouji.urls.Urls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/5/2.
 */
public class SearchFourSeasonsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private GridView gv;
    private View view;
    private List<SearchData> datas;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_gridview_items,null);

        init();


        SearchAdapter adapter = new SearchAdapter(datas,getActivity());
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(this);
        return view;
    }







    private void init(){
        gv= ((GridView) view.findViewById(R.id.searchGridView));
        datas=new ArrayList<>();
        datas.add(new SearchData("1","1月"));
        datas.add(new SearchData("2","2月"));
        datas.add(new SearchData("3","3月"));
        datas.add(new SearchData("4","4月"));
        datas.add(new SearchData("5","5月"));
        datas.add(new SearchData("6","6月"));
        datas.add(new SearchData("7","7月"));
        datas.add(new SearchData("8","8月"));
        datas.add(new SearchData("9","9月"));
        datas.add(new SearchData("10","10月"));
        datas.add(new SearchData("11","11月"));
        datas.add(new SearchData("12","12月"));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), SearchDetailsActivity.class);

        intent.putExtra("id",datas.get(i).getId());
        intent.putExtra("name",datas.get(i).getName());

        startActivity(intent);
    }
}
