package com.qianfeng.chanyouji.netutils;

import android.content.Context;
import android.os.Environment;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by aaa on 15-4-30.
 */
public class BitmapHelper {
    private static BitmapUtils bitmapUtils;

    public static void initBitmapUtils(Context context){
        bitmapUtils=new BitmapUtils(context, Environment.getDownloadCacheDirectory()+"/ChouYouJi/images",1/8.0f,10*1024*1024);
    }

    public static BitmapUtils getBitmapUtils(){
        return bitmapUtils;
    }

}
