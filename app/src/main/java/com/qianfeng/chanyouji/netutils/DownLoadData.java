package com.qianfeng.chanyouji.netutils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by aaa on 15-4-30.
 */
public class DownLoadData {

    public static void downData(final Context context, String url, final Handler handler, final int what){
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET,url,new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                Message message = handler.obtainMessage();
                message.what=what;
                message.obj=objectResponseInfo.result;
                handler.sendMessage(message);
            }





            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(context,"错误"+s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
