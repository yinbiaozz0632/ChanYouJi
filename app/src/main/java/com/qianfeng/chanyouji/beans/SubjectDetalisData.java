package com.qianfeng.chanyouji.beans;

/**
 * Created by admin on 2015/5/1.
 */
public class SubjectDetalisData {
    private int Tag;

    public int getTag() {
        return Tag;
    }

    public void setTag(int tag) {
        Tag = tag;
    }

    private String title,image_url,description,trip_name,user_name,name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectDetalisData{" +
                "title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", description='" + description + '\'' +
                ", trip_name='" + trip_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
