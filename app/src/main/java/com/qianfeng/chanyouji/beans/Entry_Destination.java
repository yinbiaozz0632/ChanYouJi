package com.qianfeng.chanyouji.beans;

import java.util.List;

/**
 * Created by aaa on 15-5-1.
 */
public class Entry_Destination {
    private String id,name_Zh_Cn,name_En,image_Url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImage_Url() {
        return image_Url;
    }

    public void setImage_Url(String image_Url) {
        this.image_Url = image_Url;
    }


    @Override
    public String toString() {
        return "Entry_Destination{" +
                "id='" + id + '\'' +
                ", name_Zh_Cn='" + name_Zh_Cn + '\'' +
                ", name_En='" + name_En + '\'' +
                ", image_Url='" + image_Url + '\'' +
                '}';
    }
}
