package com.qianfeng.chanyouji.netutils;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by aaa on 15-4-30.
 */
public class PaseJson {

    public static void jsonToList(String json){
        try {
            JSONArray array = new JSONArray(json);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
