package com.qianfeng.chanyouji.beans;

/**
 * Created by aaa on 15-5-2.
 */
public class Articles {
    private String id,name,image_url,title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Articles{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
