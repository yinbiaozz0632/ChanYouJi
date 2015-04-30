package com.qianfeng.chanyouji.beans;

/**
 * 专题首页的实体类
 * Created by 程朋飞 on 2015/4/30.
 */
public class Subject_ShouYeData {
    private int id;
    private String name;
    private String image_url;
    private String title;
    private int destination_id;
    private String updated_at;

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(int destination_id) {
        this.destination_id = destination_id;
    }

    @Override
    public String toString() {
        return "Subject_ShouYeData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", title='" + title + '\'' +
                ", destination_id=" + destination_id +
                ", updated_at=" + updated_at +
                '}';
    }
}
