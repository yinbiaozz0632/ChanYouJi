package com.qianfeng.chanyouji.beans;

/**
 * Created by aaa on 15-5-1.
 */
public class TravelNotesInfo {
        private String front_cover_photo_url;
        private String name;
        private String start_date;
        private int days;
        private int photos_count;
        private Boolean featured;
        private String image;

    public TravelNotesInfo(String front_cover_photo_url, String name, String start_date, int days, int photos_count, Boolean featured, String image) {
        this.front_cover_photo_url = front_cover_photo_url;
        this.name = name;
        this.start_date = start_date;
        this.days = days;
        this.photos_count = photos_count;
        this.featured = featured;
        this.image = image;
    }

    public String getFront_cover_photo_url() {
        return front_cover_photo_url;
    }

    public void setFront_cover_photo_url(String front_cover_photo_url) {
        this.front_cover_photo_url = front_cover_photo_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TravelNotesInfo{" +
                "front_cover_photo_url='" + front_cover_photo_url + '\'' +
                ", name='" + name + '\'' +
                ", start_date='" + start_date + '\'' +
                ", days=" + days +
                ", photos_count=" + photos_count +
                ", featured=" + featured +
                ", image='" + image + '\'' +
                '}';
    }
}
