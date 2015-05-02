package com.qianfeng.chanyouji.beans;

/**
 * Created by admin on 2015/5/2.
 */
public class SearchData {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SearchData(String id, String name) {

        this.id = id;
        this.name = name;
    }
}
