package com.qianfeng.chanyouji.parseTNjson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaa on 15-4-30.
 */
public class ParseTNjson {
    public static List<String> getList(String json) throws JSONException {

        JSONArray arr=new JSONArray(json);
        List<String> list=new ArrayList<String>();
        for(int i=0;i<arr.length();i++)
        {
            JSONObject object = arr.getJSONObject(i);
            String imageurl=object.getString("image_url");
            list.add(imageurl);
        }
         return list;
    }
}
