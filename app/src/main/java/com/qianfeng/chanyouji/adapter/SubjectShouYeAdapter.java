package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.beans.Subject_ShouYeData;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.List;

/**
 * Created by admin on 2015/4/30.
 */
public class SubjectShouYeAdapter extends BaseAdapter {

    private List<Subject_ShouYeData> datas;
    private Context context;

    public SubjectShouYeAdapter(List<Subject_ShouYeData> datas, Context context) {
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.subject_shouye_adapter_items,null);
            view.setTag(new ViewHolder(view));
        }

        ViewHolder holder = (ViewHolder) view.getTag();

        Subject_ShouYeData data = datas.get(position);

        holder.sub_name.setText(data.getName());
        holder.sub_title.setText(data.getTitle());

        BitmapHelper.getBitmapUtils().display(holder.sub_image,data.getImage_url());



        return view;
    }


    class ViewHolder{
        private TextView sub_name,sub_title;
        private ImageView sub_image;

        public ViewHolder(View v){
            sub_name= ((TextView) v.findViewById(R.id.sub_name));
            sub_title= ((TextView) v.findViewById(R.id.sub_title));
            sub_image= ((ImageView) v.findViewById(R.id.sub_image));
        }
    }


}
