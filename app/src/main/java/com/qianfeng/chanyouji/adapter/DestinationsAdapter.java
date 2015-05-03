package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.LoginFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.chanyouji.CanTrayPackageBookActivity;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.beans.Destination;
import com.qianfeng.chanyouji.beans.DestinationsDatas;
import com.qianfeng.chanyouji.beans.MyGridView;

import java.util.List;

/**
 * Created by aaa on 15-4-30.
 */
public class DestinationsAdapter extends BaseAdapter  {
    private Context context;
    private List<DestinationsDatas> list;


    public DestinationsAdapter(Context context, List<DestinationsDatas> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_destinations, null);
        MyGridView gridView= (MyGridView) convertView.findViewById(R.id.item_destinations_gv);
        DestinationsDatas destinationsDatas = list.get(position);
        List<Destination> destinations = destinationsDatas.getDestinations();
        TextView text_Contry= (TextView) convertView.findViewById(R.id.item_destinations);
        if (position==0) {
            text_Contry.setText("国外·亚洲");
        }else if (position==1){
            text_Contry.setText("国外·欧洲");
        }else if (position==2){
            text_Contry.setText("美洲、大洋洲、非洲与南美洲");
        }else if (position==3){
            text_Contry.setText("国内·港澳台");
        }else if (position==4){
            text_Contry.setText("国内,大陆");
        }
        if (list.size()!=0) {
            gridView.setAdapter(new DestinationsGridViewAdapter(context,destinations));
        }

        return convertView;
    }


}
