package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.qianfeng.chanyouji.PlansActivity;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.beans.PlansData;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.List;

/**
 * Created by aaa on 15-5-2.
 */
public class PlansAdapter extends BaseAdapter {
    private Context context;
    private List<PlansData> list;

    public PlansAdapter(Context context, List<PlansData> plansDatas) {
        this.context=context;
        this.list=plansDatas;

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
        PlansData plansData = list.get(position);
        convertView= LayoutInflater.from(context).inflate(R.layout.item_plans,null);
        ImageView plans_Image = (ImageView) convertView.findViewById(R.id.plans_image);
        BitmapHelper.getBitmapUtils().display(plans_Image,plansData.getImage_url());

        TextView text_Aims = (TextView) convertView.findViewById(R.id.plans_aims);
        text_Aims.setText(plansData.getPlan_nodes_count()+"个旅行地");

        TextView text_Description = (TextView) convertView.findViewById(R.id.plans_description);
        text_Description.setText(plansData.getDescription());

        TextView text_Play = (TextView) convertView.findViewById(R.id.plans_playtime);
        text_Play.setText(plansData.getPlan_days_count()+"天");

        ((TextView) convertView.findViewById(R.id.plans_name)).setText(plansData.getName());

        return convertView;
    }
}
