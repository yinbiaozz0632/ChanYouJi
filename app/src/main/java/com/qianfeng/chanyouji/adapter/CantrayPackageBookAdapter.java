package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.beans.Entry_Destination;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.List;

/**
 * Created by aaa on 15-5-2.
 */
public class CantrayPackageBookAdapter extends BaseAdapter {
    private Context context;
    private List<Entry_Destination> list;

    public CantrayPackageBookAdapter(Context context, List<Entry_Destination> list) {
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
        Entry_Destination entry_destination = list.get(position);
        Log.d("huahua",entry_destination.getImage_Url());
        convertView= LayoutInflater.from(context).inflate(R.layout.item_cantrybook,null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.cantr_image);
        BitmapHelper.getBitmapUtils().display(imageView,entry_destination.getImage_Url());

        return convertView;
    }

}
