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

import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.TripsActivity;
import com.qianfeng.chanyouji.adapter.SearchAdapter;
import com.qianfeng.chanyouji.beans.SearchData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/5/2.
 */
public class SearchHomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    private GridView gv;
    private View view;
    private List<SearchData> datas;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_gridview_items,null);
        gv = ((GridView) view.findViewById(R.id.searchGridView));
        init();
        SearchAdapter adapter = new SearchAdapter(datas,getActivity());
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(this);

        return view;
    }


    private void init(){
        datas=new ArrayList<>();
        datas.add(new SearchData("12","台湾"));
        datas.add(new SearchData("13","香港"));
        datas.add(new SearchData("14","澳门"));
        datas.add(new SearchData("16","云南"));
        datas.add(new SearchData("25","上海"));
        datas.add(new SearchData("20","四川"));
        datas.add(new SearchData("35","浙江"));
        datas.add(new SearchData("32","广东"));
        datas.add(new SearchData("23","北京"));
        datas.add(new SearchData("31","江苏"));
        datas.add(new SearchData("22","福建"));
        datas.add(new SearchData("26","西藏"));
        datas.add(new SearchData("17","陕西"));
        datas.add(new SearchData("11","青海"));
        datas.add(new SearchData("28","甘肃"));
        datas.add(new SearchData("21","重庆"));
        datas.add(new SearchData("33","内蒙古"));
        datas.add(new SearchData("27","海南"));
        datas.add(new SearchData("37","湖北"));
        datas.add(new SearchData("18","黑龙江"));
        datas.add(new SearchData("24","辽宁"));
        datas.add(new SearchData("10","新疆"));
        datas.add(new SearchData("34","安徽"));
        datas.add(new SearchData("30","山西"));
        datas.add(new SearchData("40","河南"));
        datas.add(new SearchData("44","贵州"));
        datas.add(new SearchData("42","河北"));
        datas.add(new SearchData("29","江西"));
        datas.add(new SearchData("41","天津"));
        datas.add(new SearchData("39","吉林"));
        datas.add(new SearchData("43","宁夏"));
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), TripsActivity.class);

        intent.putExtra("id",datas.get(i).getId());
        intent.putExtra("name_Zh_Cn",datas.get(i).getName());

        startActivity(intent);

    }
}
