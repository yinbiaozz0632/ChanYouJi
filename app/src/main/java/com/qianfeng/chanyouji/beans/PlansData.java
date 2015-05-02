package com.qianfeng.chanyouji.beans;

/**
 * Created by aaa on 15-5-2.
 */
public class PlansData {
    private String id,name,description,plan_days_count,plan_nodes_count,image_url;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlan_days_count() {
        return plan_days_count;
    }

    public void setPlan_days_count(String plan_days_count) {
        this.plan_days_count = plan_days_count;
    }

    public String getPlan_nodes_count() {
        return plan_nodes_count;
    }

    public void setPlan_nodes_count(String plan_nodes_count) {
        this.plan_nodes_count = plan_nodes_count;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "PlansData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", plan_days_count='" + plan_days_count + '\'' +
                ", plan_nodes_count='" + plan_nodes_count + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
