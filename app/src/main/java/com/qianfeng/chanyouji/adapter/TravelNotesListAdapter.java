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
import com.qianfeng.chanyouji.beans.TravelNotesInfo;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.List;

/**
 * Created by aaa on 15-4-30.
 */
public class TravelNotesListAdapter extends BaseAdapter {

    private Context context;
    private List<TravelNotesInfo> tnlist;
    public TravelNotesListAdapter(Context context,List<TravelNotesInfo> tnlist)
    {
            this.context=context;
            this.tnlist=tnlist;
    }
    @Override
    public int getCount() {
        return tnlist.size();
    }

    @Override
    public Object getItem(int position) {
        return tnlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate( R.layout.tn_listitem, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        final ViewHolder holder= (ViewHolder) convertView.getTag();

        TravelNotesInfo info=tnlist.get(position);
        holder.title.setText(info.getName());
        holder.details.setText(info.getStart_date()+"/"+info.getDays()+"天, "+info.getPhotos_count()+"图");

//        BitmapHelper.getBitmapUtils().display();


        BitmapHelper.getBitmapUtils().display(holder.big_iv,info.getFront_cover_photo_url(),new BitmapLoadCallBack<ImageView>() {
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





        BitmapHelper.getBitmapUtils().display(holder.icon_iv,info.getImage());

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
            n_pb= (ProgressBar) v.findViewById(R.id.n_pb);
        }
    }
}
