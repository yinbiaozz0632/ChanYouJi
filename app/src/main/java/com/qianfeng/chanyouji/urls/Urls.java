package com.qianfeng.chanyouji.urls;

/**
 * Created by admin on 2015/4/30.
 */
public class Urls {

    //专题的接口  page=1
    public static String Subject_ShouYe="http://chanyouji.com/api/articles.json?page=";
    //专题接口详情 改变 566
    public static String Subject_XiangQing="https://chanyouji.com/api/articles/";

    //搜索四季的URL  拼接12 页码    12.json?page=1
    public static String Search_SiJi="http://chanyouji.com/api/trips/month/";
    //搜索国内国外
    public static String Search_GuoNeiAndWai="http://chanyouji.com/api/destinations/trips/12.json?page=1";

    //搜索的接口

    public static String Search="https://chanyouji.com/api/destinations/list.json";



}
