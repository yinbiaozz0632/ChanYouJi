package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import com.qianfeng.chanyouji.beans.TripsData;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.List;

/**
 * Created by aaa on 15-5-2.
 */
public class TripsItemAdapter extends BaseAdapter {
    private Context context;
    private  List<TripsData> list;

    public TripsItemAdapter(Context context, List<TripsData> list) {
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
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate( R.layout.tn_listitem, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        final ViewHolder holder= (ViewHolder) convertView.getTag();
        TripsData tripsData = list.get(position);
        holder.title.setText(tripsData.getName());
        holder.details.setText(tripsData.getStart_Date()+"/"+tripsData.getDays()+"天, "+tripsData.getPhotos_Count()+"图");
        BitmapHelper.getBitmapUtils().display(holder.big_iv,tripsData.getFront_Cover_Photo_Url(),new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                holder.big_iv.setImageBitmap(bitmap);
            }

            @Override
            public void onLoading(ImageView container, String uri, BitmapDisplayConfig config, long total, long current) {
                holder.n_pb.setVisibility(View.VISIBLE);
                holder.n_pb.setProgress(0);
                holder.n_pb.setMax((int)total);
                holder.n_pb.incrementProgressBy((int)current);
                if(total==current) {
                    holder.n_pb.setVisibility(View.GONE);
                }



            }

            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });




        BitmapHelper.getBitmapUtils().display(holder.icon_iv,tripsData.getImage());

        return convertView;
    }


    class ViewHolder
    {
        private ImageView big_iv;
        private TextView title;
        private TextView details;
        private ImageView icon_iv;
        private ProgressBar n_pb;
        public ViewHolder(View v) {
            big_iv= (ImageView) v.findViewById(R.id.iv_item);
            title= (TextView) v.findViewById(R.id.tv1_item);
            details= (TextView) v.findViewById(R.id.tv2_item);
            icon_iv= (ImageView) v.findViewById(R.id.smalliv_item);
            n_pb = (ProgressBar) v.findViewById(R.id.n_pb);
        }
    }

}
