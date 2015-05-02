package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.qianfeng.chanyouji.CanTrayPackageBookActivity;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.beans.Destination;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.List;

/**
 * Created by aaa on 15-4-30.
 */
public class DestinationsGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Destination> list;
    public DestinationsGridViewAdapter(Context context, List<Destination> list) {
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
        final Destination destination = list.get(position);
        convertView= LayoutInflater.from(context).inflate(R.layout.item_gridview, null);

        ImageView destinations_iv= (ImageView) convertView.findViewById(R.id.item_destinations_iv);
        BitmapUtils bitmapUtils = BitmapHelper.getBitmapUtils();
        bitmapUtils.display(destinations_iv,destination.getImage_Url());

        TextView destinations_tv_cn= (TextView) convertView.findViewById(R.id.item_destinations_tv_cn);
        destinations_tv_cn.setText(destination.getName_Zh_Cn());

        TextView destinations_tv_en= (TextView) convertView.findViewById(R.id.item_destinations_tv_en);
        destinations_tv_en.setText(destination.getName_En());

        TextView destinations_tv_tra= (TextView) convertView.findViewById(R.id.item_destinations_tv_tra);
        destinations_tv_tra.setText(destination.getPoi_Count());

        destinations_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_zh_cn = destination.getName_Zh_Cn();
                Intent intent = new Intent(context, CanTrayPackageBookActivity.class);
                intent.putExtra("id",destination.getId());
                intent.putExtra("name_Zh_cn",name_zh_cn);

                context.startActivity(intent);
            }
        });


        return convertView;
    }
}
