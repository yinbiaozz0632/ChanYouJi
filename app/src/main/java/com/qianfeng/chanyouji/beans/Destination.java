package com.qianfeng.chanyouji.beans;

/**
 * Created by aaa on 15-4-30.
 */
public class Destination {

    private String image_Url,name_Zh_Cn,name_En,poi_Count;

    public String getImage_Url() {
        return image_Url;
    }

    public void setImage_Url(String image_Url) {
        this.image_Url = image_Url;
    }

    public String getName_Zh_Cn() {
        return name_Zh_Cn;
    }

    public void setName_Zh_Cn(String name_Zh_Cn) {
        this.name_Zh_Cn = name_Zh_Cn;
    }

    public String getName_En() {
        return name_En;
    }

    public void setName_En(String name_En) {
        this.name_En = name_En;
    }

    public String getPoi_Count() {
        return poi_Count;
    }

    public void setPoi_Count(String poi_Count) {
        this.poi_Count = poi_Count+"旅行地";
    }

    @Override
    public String toString() {
        return "Destination{" +
                "image_Url='" + image_Url + '\'' +
                ", name_Zh_Cn='" + name_Zh_Cn + '\'' +
                ", name_En='" + name_En + '\'' +
                ", poi_Count='" + poi_Count + '\'' +
                '}';
    }
}
