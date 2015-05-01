package com.qianfeng.chanyouji.beans;

import java.util.List;

/**
 * Created by aaa on 15-4-30.
 */
public class DestinationsDatas {

    private List<Destination> destinations;

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    @Override
    public String toString() {
        return "DestinationsDatas{" +
                "destinations=" + destinations +
                '}';
    }
}
