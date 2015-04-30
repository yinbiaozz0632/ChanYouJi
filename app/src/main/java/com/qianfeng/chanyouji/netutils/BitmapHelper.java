package com.qianfeng.chanyouji.netutils;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by aaa on 15-4-30.
 */
public class BitmapHelper {
    private static BitmapUtils bitmapUtils;

    public static void initBitmapUtils(Context context){

        bitmapUtils=new BitmapUtils(context);
    }

    public static BitmapUtils getBitmapUtils(){
        return bitmapUtils;
    }

}
