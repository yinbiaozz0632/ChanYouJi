package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.beans.SearchData;

import java.util.List;

/**
 * Created by admin on 2015/5/2.
 */
public class SearchAdapter extends BaseAdapter {

    private List<SearchData> datas;
    private Context context;

    public SearchAdapter(List<SearchData> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.search_adapter_items, null);

            convertView.setTag(new ViewHolder(convertView));
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.tv_Search.setText(datas.get(position).getName());




        return convertView;
    }

    class ViewHolder {
        private TextView tv_Search;

        public ViewHolder(View v) {
            tv_Search = (TextView) v.findViewById(R.id.tv_search);
        }

    }


}
