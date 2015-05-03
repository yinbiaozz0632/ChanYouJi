package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
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

        final ViewHolder holder = (ViewHolder) view.getTag();

        Subject_ShouYeData data = datas.get(position);

        holder.sub_name.setText(data.getName());
        holder.sub_title.setText(data.getTitle());

//        if(holder.sub_image==null) {
//
//        }
        BitmapHelper.getBitmapUtils().display(holder.sub_image,data.getImage_url(),new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                holder.sub_image.setImageBitmap(bitmap);
            }


            @Override
            public void onLoading(ImageView container, String uri, BitmapDisplayConfig config, long total, long current) {
//                super.onLoading(container, uri, config, total, current);
//                Log.d("Tag",total+"");
                holder.sub_pb.setVisibility(View.VISIBLE);
                holder.sub_pb.setProgress(0);
                holder.sub_pb.setMax((int)total);
                holder.sub_pb.incrementProgressBy((int)current);
                if(total==current) {
                    holder.sub_pb.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });



        return view;
    }


    class ViewHolder{
        private TextView sub_name,sub_title;
        private ImageView sub_image;
        private ProgressBar sub_pb;

        public ViewHolder(View v){
            sub_name= ((TextView) v.findViewById(R.id.sub_name));
            sub_title= ((TextView) v.findViewById(R.id.sub_title));
            sub_image= ((ImageView) v.findViewById(R.id.sub_image));
            sub_pb = (ProgressBar) v.findViewById(R.id.sub_pb);
        }
    }


}
