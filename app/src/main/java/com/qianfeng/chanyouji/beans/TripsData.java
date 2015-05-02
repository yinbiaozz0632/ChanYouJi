package com.qianfeng.chanyouji.beans;

/**
 * Created by aaa on 15-5-2.
 */
public class TripsData {
    private String name,photos_Count,start_Date,days,front_Cover_Photo_Url,image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotos_Count() {
        return photos_Count;
    }

    public void setPhotos_Count(String photos_Count) {
        this.photos_Count = photos_Count;
    }

    public String getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(String start_Date) {
        this.start_Date = start_Date;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getFront_Cover_Photo_Url() {
        return front_Cover_Photo_Url;
    }

    public void setFront_Cover_Photo_Url(String front_Cover_Photo_Url) {
        this.front_Cover_Photo_Url = front_Cover_Photo_Url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TripsData{" +
                "name='" + name + '\'' +
                ", photos_Count='" + photos_Count + '\'' +
                ", start_Date='" + start_Date + '\'' +
                ", days='" + days + '\'' +
                ", front_Cover_Photo_Url='" + front_Cover_Photo_Url + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
