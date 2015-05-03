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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/5/2.
 */
public class SearchForeignFragment extends Fragment implements AdapterView.OnItemClickListener {

    private View view;
    private List<SearchData> datas;
    private GridView gv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_gridview_items,null);
        init();
        gv = ((GridView) view.findViewById(R.id.searchGridView));
        SearchAdapter adapter = new SearchAdapter(datas,getActivity());
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(this);

        return view;
    }

    /**
     * 初始化数据
     */
    private void init(){
        datas=new ArrayList<>();
        datas.add(new SearchData("55","日本"));
        datas.add(new SearchData("45","泰国"));
        datas.add(new SearchData("57","美国"));
        datas.add(new SearchData("47","韩国"));
        datas.add(new SearchData("71","马来西亚"));
        datas.add(new SearchData("62","法国"));
        datas.add(new SearchData("80","意大利"));
        datas.add(new SearchData("67","英国"));
        datas.add(new SearchData("63","德国"));
        datas.add(new SearchData("54","柬埔寨"));
        datas.add(new SearchData("53","新加坡"));
        datas.add(new SearchData("61","澳大利亚"));
        datas.add(new SearchData("90","瑞士"));
        datas.add(new SearchData("77","西班牙"));
        datas.add(new SearchData("61","印度尼西亚"));
        datas.add(new SearchData("49","越南"));
        datas.add(new SearchData("84","奥地利"));
        datas.add(new SearchData("73","菲律宾"));
        datas.add(new SearchData("68","新西兰"));
        datas.add(new SearchData("69","土耳其"));
        datas.add(new SearchData("59","马尔代夫"));
        datas.add(new SearchData("56","尼泊尔"));
        datas.add(new SearchData("89","荷兰"));
        datas.add(new SearchData("72","加拿大"));
        datas.add(new SearchData("60","阿联酋"));
        datas.add(new SearchData("83","希腊"));
        datas.add(new SearchData("81","捷克"));
        datas.add(new SearchData("48","斯里兰卡"));
        datas.add(new SearchData("96","俄罗斯"));
        datas.add(new SearchData("99","比利时"));
        datas.add(new SearchData("46","印度"));
        datas.add(new SearchData("65","摩纳哥"));
        datas.add(new SearchData("97","匈牙利"));
        datas.add(new SearchData("91","芬兰"));
        datas.add(new SearchData("92","瑞典"));
        datas.add(new SearchData("85","挪威"));
        datas.add(new SearchData("93","丹麦"));
        datas.add(new SearchData("101","葡萄牙"));
        datas.add(new SearchData("50","缅甸"));
        datas.add(new SearchData("75","老挝"));
        datas.add(new SearchData("82","埃及"));
        datas.add(new SearchData("100","南非"));
        datas.add(new SearchData("79","墨西哥"));
        datas.add(new SearchData("107","毛里求斯"));
        datas.add(new SearchData("108","卡塔尔"));
        datas.add(new SearchData("70","以色列"));
        datas.add(new SearchData("104","肯尼亚"));
        datas.add(new SearchData("66","卢森堡"));
        datas.add(new SearchData("103","列支敦士登"));
        datas.add(new SearchData("211","伊朗"));
        datas.add(new SearchData("102","波兰"));
        datas.add(new SearchData("74","爱尔兰"));
        datas.add(new SearchData("109","斯洛伐克"));
        datas.add(new SearchData("94","冰岛"));
        datas.add(new SearchData("216","波多黎各"));
        datas.add(new SearchData("78","巴西"));
        datas.add(new SearchData("210","帕劳"));
        datas.add(new SearchData("51","朝鲜"));
        datas.add(new SearchData("105","斐济"));
        datas.add(new SearchData("223","约旦"));
        datas.add(new SearchData("112","突尼斯"));
        datas.add(new SearchData("207","塞舌尔"));
        datas.add(new SearchData("95","秘鲁"));
        datas.add(new SearchData("208","爱沙尼亚"));
        datas.add(new SearchData("106","摩洛哥"));
        datas.add(new SearchData("215","克罗地亚"));
        datas.add(new SearchData("205","马耳他"));
        datas.add(new SearchData("232","巴基斯坦"));
        datas.add(new SearchData("52","不丹"));
        datas.add(new SearchData("87","智利"));
        datas.add(new SearchData("110","斯洛文尼亚"));
        datas.add(new SearchData("86","阿根廷"));
        datas.add(new SearchData("88","克吧"));
        datas.add(new SearchData("218","马其顿"));
        datas.add(new SearchData("224","立陶宛"));
        datas.add(new SearchData("217","赛普洛斯"));
        datas.add(new SearchData("219","塞维尔亚"));
        datas.add(new SearchData("220","黑山共和国"));
        datas.add(new SearchData("222","保加利亚"));
        datas.add(new SearchData("111","坦桑尼亚"));
        datas.add(new SearchData("372","文莱"));
        datas.add(new SearchData("212","马达加斯加"));
        datas.add(new SearchData("213","南极"));
        datas.add(new SearchData("221","波黑共和国"));
        datas.add(new SearchData("233","孟加拉国"));
        datas.add(new SearchData("225","哈萨克斯坦"));
        datas.add(new SearchData("342","蒙古国"));
        datas.add(new SearchData("214","哥斯达黎加"));
        datas.add(new SearchData("229","委内瑞拉"));
        datas.add(new SearchData("237","罗马尼亚"));
        datas.add(new SearchData("228","布隆迪"));
        datas.add(new SearchData("230","巴林"));
        datas.add(new SearchData("241","阿曼"));
        datas.add(new SearchData("243","吉布提"));
        datas.add(new SearchData("243","沙特阿拉伯"));
        datas.add(new SearchData("252","白俄罗斯"));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), TripsActivity.class);

        intent.putExtra("id",datas.get(i).getId());
        intent.putExtra("name_Zh_Cn",datas.get(i).getName());

        startActivity(intent);



    }
}
