package com.qianfeng.chanyouji.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.qianfeng.chanyouji.R;
import com.qianfeng.chanyouji.beans.SubjectDetalisData;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.List;

/**
 * Created by admin on 2015/5/1.
 */
public class SubjectdetalilsAdapter extends BaseAdapter implements ImageLoader.ImageCache{

    private List<SubjectDetalisData> datas;
    private Context context;
    private ImageLoader loder;
    private LruCache<String, Bitmap> cache;

    public SubjectdetalilsAdapter(List<SubjectDetalisData> datas, Context context) {
        this.datas = datas;
        this.context = context;
        loder=new ImageLoader(Volley.newRequestQueue(context), this);

        cache=new LruCache<String, Bitmap>((int) (Runtime.getRuntime().totalMemory()/8)){
            @Override                          //运行时内存的8分之一
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight();//API12以前，获得行的字节*高度
            }
        };



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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view= LayoutInflater.from(context).inflate(R.layout.subjectdeatils_items,null);
            view.setTag(new ViewHolder(view));
        }

        ViewHolder holder= ((ViewHolder) view.getTag());

        SubjectDetalisData data = datas.get(i);


        holder.title.setText(data.getTitle());


        holder.description.setText(data.getDescription());
        holder.sub_name.setText(data.getName());
        holder.user_name.setText(data.getUser_name());
        holder.trip_name.setText(data.getTrip_name());

        holder.image_sub_adapter.setImageUrl(data.getImage_url(),loder);

        return view;
    }

    @Override
    public Bitmap getBitmap(String s) {
        return cache.get(s);//先从缓存中去
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        cache.put(s, bitmap);//下载后先存到缓存中
    }

    class ViewHolder{
        private TextView title,description,sub_name,trip_name,user_name;
        private NetworkImageView image_sub_adapter;
        public ViewHolder(View v){
            title= ((TextView) v.findViewById(R.id.title));
            description= ((TextView) v.findViewById(R.id.description));
            sub_name= ((TextView) v.findViewById(R.id.sub_name));
            trip_name= ((TextView) v.findViewById(R.id.trip_name));
            user_name= ((TextView) v.findViewById(R.id.user_name));
            image_sub_adapter= ((NetworkImageView) v.findViewById(R.id.image_sub_adapter));


        }
    }


}
