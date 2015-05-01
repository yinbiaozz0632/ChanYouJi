package com.qianfeng.chanyouji.netutils;

import android.util.Log;

import com.qianfeng.chanyouji.beans.Destination;
import com.qianfeng.chanyouji.beans.DestinationsDatas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaa on 15-4-30.
 */
public class PaseJson {
    public static List<DestinationsDatas> jsonToList(String json) {
        try {
            JSONArray array = new JSONArray(json);
            List<DestinationsDatas> list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                DestinationsDatas destinationsDatas = new DestinationsDatas();
                JSONObject jsonObject = array.getJSONObject(i);
                JSONArray destinations = jsonObject.getJSONArray("destinations");
                List<Destination> list1 = new ArrayList<>();
                for (int j = 0; j < destinations.length(); j++) {
                    Destination destination = new Destination();
                    JSONObject jsonObject1 = destinations.getJSONObject(j);
                    destination.setImage_Url(jsonObject1.getString("image_url"));
                    destination.setName_En(jsonObject1.getString("name_en"));
                    destination.setName_Zh_Cn(jsonObject1.getString("name_zh_cn"));
                    destination.setPoi_Count(jsonObject1.getString("poi_count"));
                    list1.add(destination);
                }
                destinationsDatas.setDestinations(list1);
                list.add(destinationsDatas);
            }
            return list;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
